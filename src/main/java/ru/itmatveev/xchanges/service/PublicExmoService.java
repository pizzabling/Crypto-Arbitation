package ru.itmatveev.xchanges.service;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoOrderBook;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoPairSettings;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoTicker;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoTrades;
import ru.itmatveev.xchanges.repo.ExmoRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Component
public class PublicExmoService {
    private ExmoRepo repo;
    private int id = 0;

    public PublicExmoService(ExmoRepo repo) {
        this.repo = repo;
    }

    public ExmoTicker getExmoTickerListById(int id){
        return repo.getExmoTickerListById(id);
    }

    public List<ExmoTicker> getExmoTickerList() throws Exception {
        return repo.getExmoTickerList();
    }

    public void clearExmoTickerList(){
        id = 0;
        repo.clearExmoTickerList();
    }

    public int returnCount(){
        return id;
    }

    public List<ExmoPairSettings> getExmoPairSettings() throws Exception {
        return repo.getExmoPairSettings();
    }

    public ExmoTrades getExmoTradesInfo() {
        return repo.getTradesInfo();
    }

    public ExmoOrderBook getExmoOrderBookInfo() {
        return repo.getOrderBookInfo();
    }

    public void addTradesInfo(ExmoTrades setTrades) {
        repo.addTradesInfo(setTrades);
    }

    public void addOrderBookInfo(ExmoOrderBook setOrderBook) {
        repo.addOrderBookInfo(setOrderBook);
    }

    public void addPair(String pairName) throws Exception {
        parseExmoTrades(pairName);
        parseExmoOrderBook(pairName);

    }

    public void addExmoTickerList(String pairName, String buyPrice, String sellPrice, String lastTrade, String high, String low, String avg, String vol, String vol_curr) {
        ExmoTicker tickers = new ExmoTicker(id, pairName, buyPrice, sellPrice, lastTrade, high, low, vol, avg, vol_curr);
        repo.addExmoTickerList(tickers);
        id = id + 1;
    }

    public void addExmoPairSettings(ExmoPairSettings pairSettings) {
        repo.addExmoPairSettings(pairSettings);
    }

    public Object parseExmoTrades(String pairName) throws Exception {
        URL url = new URL("https://api.exmo.com/v1/trades/?pair=" + pairName);
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
//        String responseBody = sb.toString();
//        JSONParser parser = new JSONParser();
//
//        Object obj = parser.parse(responseBody);
//        JSONObject jsonObject = (JSONObject) obj;
//
//        Object getPair = jsonObject.get(pairName);
//        JSONObject casteToObject = (JSONObject) getPair;
//
//        String tradeId = (String) casteToObject.get("trade_id");
//        String type = (String) casteToObject.get("type");
//        String price = (String) casteToObject.get("price");
//        String quantity = (String) casteToObject.get("quantity");
//        String amount = (String) casteToObject.get("amount");
//        String date = (String) casteToObject.get("date");
//
//        ExmoTrades setTrades = new ExmoTrades(pairName, tradeId, type, price, quantity, amount, date);
//        addTradesInfo(setTrades);
        return null;
    }

    public Object parseExmoOrderBook(String pairName) throws Exception {
        URL url = new URL("https://api.exmo.com/v1/order_book/?pair=" + pairName);
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
//        String responseBody = sb.toString();
//        JSONParser parser = new JSONParser();
//
//        Object obj = parser.parse(responseBody);
//        JSONObject jsonObject = (JSONObject) obj;
//
//        Object getPair = jsonObject.get(pairName);
//        JSONObject casteToObject = (JSONObject) getPair;
//
//        String ask_quantity = (String) casteToObject.get("ask_quantity");
//        String ask_amount = (String) casteToObject.get("ask_amount");
//        String ask_top = (String) casteToObject.get("ask_top");
//        String bid_quantity = (String) casteToObject.get("bid_quantity");
//        String bid_amount = (String) casteToObject.get("bid_amount");
//        String bid_top = (String) casteToObject.get("bid_top");
//        String ask = (String) casteToObject.get("ask");
//        String bid = (String) casteToObject.get("bid");
//
//        ExmoOrderBook setOrderBook = new ExmoOrderBook(pairName, ask_quantity, ask_amount, ask_top, bid_quantity, bid_amount,
//                bid_top, ask, bid);
//        addOrderBookInfo(setOrderBook);
        return null;
    }

    @Scheduled(fixedDelay = 60000)
    public Object parseExmoTicker() throws Exception {
        clearExmoTickerList();

        URL url = new URL("https://api.exmo.com/v1/ticker");
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
        JSONObject jsonObject = new JSONObject(responseBody.trim());
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                Object getPair = jsonObject.get(key);
                JSONObject casteToObject = (JSONObject) getPair;
                String replaceKey = key.replace("_","/");
                String buy_price = (String) casteToObject.get("buy_price");
                String sell_price = (String) casteToObject.get("sell_price");
                String last_trade = (String) casteToObject.get("last_trade");
                String high = (String) casteToObject.get("high");
                String low = (String) casteToObject.get("low");
                String avg = (String) casteToObject.get("avg");
                String vol = (String) casteToObject.get("vol");
                String vol_curr = (String) casteToObject.get("vol_curr");
                addExmoTickerList(replaceKey, buy_price, sell_price, last_trade, high, low, avg, vol, vol_curr);
            }

        }
        System.out.println("Exmo parsed");

        return null;
    }

    public Object parseExmoPairSettings() throws Exception {
        URL url = new URL("https://api.exmo.com/v1/pair_settings/");
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
        JSONObject jsonObject = new JSONObject(responseBody.trim());
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                Object getPair = jsonObject.get(key);
                JSONObject casteToObject = (JSONObject) getPair;

                String min_quantity = (String) casteToObject.get("min_quantity");
                String max_quantity = (String) casteToObject.get("max_quantity");
                String min_price = (String) casteToObject.get("min_price");
                String max_price = (String) casteToObject.get("max_price");
                String min_amount = (String) casteToObject.get("min_amount");
                String max_amount = (String) casteToObject.get("max_amount");

                ExmoPairSettings pairSettings = new ExmoPairSettings(key, min_quantity, max_quantity, min_price, max_price,
                        min_amount, max_amount);
                addExmoPairSettings(pairSettings);
            }
        }
        return null;
    }
}
