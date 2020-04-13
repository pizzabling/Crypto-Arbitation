package ru.itmatveev.xchanges.service;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.xchanges.poloniex.PoloniexTicker;
import ru.itmatveev.xchanges.repo.PoloniexRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

@Service
@Component
public class PublicPoloniexService {
    private PoloniexRepo repo;
    private int id = 0;

    public PublicPoloniexService(PoloniexRepo repo) {
        this.repo = repo;
    }

    public List<PoloniexTicker> getPoloniexTickerList(){
        return repo.getPoloniexTickerList();
    }

    public PoloniexTicker getPoloniexTickerListByPairName(String pairName){
        return repo.getPoloniexTickerListByPairName(pairName);
    }

    public PoloniexTicker getPoloniexTickerListById(int id){
        return repo.getPoloniexTickerListById(id);
    }

    public void addPoloniexTickerList(String pairName, String last, String lowestAsk, String highestBid,
                                      String percentChange, String baseVolume, String quoteVolume, String isFrozen, String high, String low){
        PoloniexTicker ticker = new PoloniexTicker(id, pairName, last, lowestAsk, highestBid, percentChange, baseVolume,
                quoteVolume, isFrozen, high, low);
        repo.addPoloniexTickerList(ticker);
        id = id + 1;
    }

    public void clearTickerList(){
        repo.clearTickerList();
        id = 0;
    }
    @Scheduled(fixedDelay = 60000)
    public void parsePoloniexTickerList() throws Exception {
        clearTickerList();

        URL url = new URL("https://poloniex.com/public?command=returnTicker");
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
                String last = (String) casteToObject.get("last");
                String lowestAsk = (String) casteToObject.get("lowestAsk");
                String highestBid = (String) casteToObject.get("highestBid");
                String percentChange = (String) casteToObject.get("percentChange");
                String baseVolume = (String) casteToObject.get("baseVolume");
                String quoteVolume = (String) casteToObject.get("quoteVolume");
                String isFrozen = (String) casteToObject.get("isFrozen");
                String high = (String) casteToObject.get("high24hr");
                String low = (String) casteToObject.get("low24hr");
                addPoloniexTickerList(replaceKey,last,lowestAsk,highestBid,percentChange,baseVolume,quoteVolume,isFrozen,
                        high,low);
            }

        }
        System.out.println("Poloniex parsed");
    }
}
