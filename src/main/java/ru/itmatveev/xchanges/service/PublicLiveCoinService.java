package ru.itmatveev.xchanges.service;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveBidAsk;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveOrderBook;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveTicker;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveTrade;
import ru.itmatveev.xchanges.repo.LiveCoinRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@Component
public class PublicLiveCoinService {
    private LiveCoinRepo repo;
    private int id = 0;

    public PublicLiveCoinService(LiveCoinRepo repo) {
        this.repo = repo;
    }
    public int returnCount(){
        return id;
    }

    public LiveTicker getLiveCoinTickerListById(int id){
        return repo.getTickerListById(id);
    }

    public LiveBidAsk getBidAskInfo() {
        return repo.getBidAsk();
    }

    public LiveOrderBook getOrderBookInfo() {
        return repo.getOrderBook();
    }

    public List<LiveTicker> getTickerInfo() {
        return repo.getTickerList();
    }

    public void clearLiveCoinTickerList(){
        id = 0;
        repo.clearLiveCoinTickerList();
    }

    public LiveTrade getTradeInfo() {
        return repo.getTrade();
    }

    public void addBidAskInfo(LiveBidAsk setBidAsk) {
        repo.addBidAsk(setBidAsk);
    }

    public void addOrderBook(LiveOrderBook setOrderBook) {
        repo.addOrderBook(setOrderBook);
    }

    public void addTickerList(String pairName, Object last, Object high, Object low, Object volume, Object vwap,
                              Object max_bid, Object min_ask, Object best_bid, Object best_ask) {
        LiveTicker ticker = new LiveTicker(id, pairName, last, high, low, volume, vwap, max_bid, min_ask, best_bid,
                best_ask);
        repo.addTickerList(ticker);
        id = id + 1;
    }

    public void addTrade(LiveTrade setTrade) {
        repo.addTrade(setTrade);
    }


    public Object parseBidAsk(String pairName) throws Exception {
        String result = pairName.replace("_", "/");
        URL url = new URL("https://api.livecoin.net/exchange/maxbid_minask?currencyPair=" + result);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream is = request.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        String responseBody = sb.toString();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(responseBody);
        JSONObject jsonObject = (JSONObject) obj;

        Object getPair = jsonObject.get(pairName);
        JSONObject casteToObject = (JSONObject) getPair;

        String maxBid = (String) casteToObject.get("maxBid");
        String minAsk = (String) casteToObject.get("minAsk");

        LiveBidAsk setBidAsk = new LiveBidAsk(pairName, maxBid, minAsk);
        addBidAskInfo(setBidAsk);
        return null;
    }

    public Object parseCoin(String pairName) throws Exception {
        String result = pairName.replace("_", "/");
        URL url = new URL("https://api.livecoin.net/info/coinInfo" + result);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream is = request.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        String responseBody = sb.toString();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(responseBody);
        JSONObject jsonObject = (JSONObject) obj;

        Object getPair = jsonObject.get(pairName);
        JSONObject casteToObject = (JSONObject) getPair;

        String maxBid = (String) casteToObject.get("maxBid");
        String minAsk = (String) casteToObject.get("minAsk");

        LiveBidAsk setBidAsk = new LiveBidAsk(pairName, maxBid, minAsk);
        addBidAskInfo(setBidAsk);
        return null;
    }

    public Object getOrderBook(String pairName) throws Exception {
        String result = pairName.replace("_", "/");
        URL url = new URL("https://api.livecoin.net/exchange/order_book?currencyPair=" + result);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream is = request.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        String responseBody = sb.toString();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(responseBody);
        JSONObject jsonObject = (JSONObject) obj;

        Object getPair = jsonObject.get(pairName);
        JSONObject casteToObject = (JSONObject) getPair;

        String timestamp = (String) casteToObject.get("timestamp");
        String asks = (String) casteToObject.get("asks");
        String bids = (String) casteToObject.get("bids");

        LiveOrderBook setOrderBook = new LiveOrderBook(pairName, timestamp, asks, bids);
        addOrderBook(setOrderBook);
        return null;
    }
    @Scheduled(fixedDelay = 60000)
    public Object parseTickerList() throws Exception {
        clearLiveCoinTickerList();

        URL url = new URL("https://api.livecoin.net/exchange/ticker");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream is = request.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        sb.insert(0, "{\"info\": ");
        String responseBody = sb.toString();

        int lenght = responseBody.length();
        StringBuilder plusSymbol = new StringBuilder(responseBody);
        plusSymbol.insert(lenght, "}");
        String result = plusSymbol.toString();


        org.json.JSONObject response = new org.json.JSONObject(result);
        JSONArray array = response.getJSONArray("info");
        for (int i = 0; i < array.length(); i++) {
            org.json.JSONObject object = array.getJSONObject(i);
            String symbol = (String) object.get("symbol");
            Object last = object.get("last");
            Object high = object.get("high");
            Object low = object.get("low");
            Object volume = object.get("volume");
            Object vwap = object.get("vwap");
            Object max_bid = object.get("max_bid");
            Object min_ask = object.get("min_ask");
            Object best_bid = object.get("best_bid");
            Object best_ask = object.get("best_ask");

            addTickerList(symbol, last, high, low, volume, vwap, max_bid, min_ask,
                    best_bid, best_ask);
        }
        System.out.println("LiveCoin parsed");
        return null;
    }

    public Object getTrade(String pairName) throws Exception {
        String result = pairName.replace("_", "/");
        URL url = new URL("https://api.livecoin.net/exchange/ticker?currencyPair=" + result);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream is = request.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        String responseBody = sb.toString();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(responseBody);
        JSONObject jsonObject = (JSONObject) obj;

        Object getPair = jsonObject.get(pairName);
        JSONObject casteToObject = (JSONObject) getPair;

        String time = (String) casteToObject.get("time");
        String id = (String) casteToObject.get("id");
        String price = (String) casteToObject.get("price");
        String quantity = (String) casteToObject.get("quantity");
        String type = (String) casteToObject.get("type");

        LiveTrade setTrade = new LiveTrade(pairName, time, id, price, quantity, type);
        addTrade(setTrade);
        return null;
    }

}






