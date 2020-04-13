package ru.itmatveev.xchanges;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.itmatveev.xchanges.service.PublicExmoService;
import ru.itmatveev.xchanges.service.PublicLiveCoinService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Configuration
@SpringBootApplication
@EnableScheduling

public class XchangesApplication {

    public static void main(String[] args){
        SpringApplication.run(XchangesApplication.class, args);
//
//        URL url = new URL("https://api.livecoin.net/exchange/ticker");
//        HttpURLConnection request = (HttpURLConnection) url.openConnection();
//        request.setRequestMethod("GET");
//        request.connect();
//        InputStream is = request.getInputStream();
//        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        try {
//            while ((line = bf_reader.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//        } catch (IOException e) {
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//            }
//        }
//        sb.insert(0, "{\"info\": ");
//        String responseBody = sb.toString();
//
//        int lenght = responseBody.length();
//        StringBuilder plusSymbol = new StringBuilder(responseBody);
//        plusSymbol.insert(lenght, "}");
//        String result = plusSymbol.toString();
//
//        JSONObject response = new JSONObject(result);
//        JSONArray array = response.getJSONArray("info");
//        for (int i = 0; i < array.length(); i++) {
//            JSONObject object = array.getJSONObject(i);
//            String symbol = (String) object.get("symbol");
//            Object last = object.get("last");
//            Object high = object.get("high");
//            Object low = object.get("low");
//            Object volume = object.get("volume");
//            Object vwap = object.get("vwap");
//            Object max_bid = object.get("max_bid");
//            Object min_ask = object.get("min_ask");
//            Object best_bid = object.get("best_bid");
//            Object best_ask = object.get("best_ask");
//            System.out.println(symbol + ": " + best_ask);
        }
    }


