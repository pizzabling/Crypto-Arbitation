package ru.itmatveev.xchanges.data.xchanges.livecoin;

import lombok.Data;

@Data
public class LiveTicker {
    private int id;
    private String pairName;
    private Object last;
    private Object high;
    private Object low;
    private Object volume;
    private Object vwap;
    private Object max_bid;
    private Object min_ask;
    private Object best_bid;
    private Object best_ask;

    public LiveTicker(int id, String pairName, Object last, Object high, Object low, Object volume, Object vwap, Object max_bid, Object min_ask, Object best_bid, Object best_ask) {
        this.id = id;
        this.pairName = pairName;
        this.last = last;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.vwap = vwap;
        this.max_bid = max_bid;
        this.min_ask = min_ask;
        this.best_bid = best_bid;
        this.best_ask = best_ask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getLast() {
        return last.toString();
    }

    public void setLast(Object last) {
        this.last = last;
    }

    public String getHigh() {
        return high.toString();
    }

    public void setHigh(Object high) {
        this.high = high;
    }

    public String getLow() {
        return low.toString();
    }

    public void setLow(Object low) {
        this.low = low;
    }

    public String getVolume() {
        return volume.toString();
    }

    public void setVolume(Object volume) {
        this.volume = volume;
    }

    public String getVwap() {
        return vwap.toString();
    }

    public void setVwap(Object vwap) {
        this.vwap = vwap;
    }

    public String getMax_bid() {
        return max_bid.toString();
    }

    public void setMax_bid(Object max_bid) {
        this.max_bid = max_bid;
    }

    public String getMin_ask() {
        return min_ask.toString();
    }

    public void setMin_ask(Object min_ask) {
        this.min_ask = min_ask;
    }

    public String getBest_bid() {
        return best_bid.toString();
    }

    public void setBest_bid(Object best_bid) {
        this.best_bid = best_bid;
    }

    public String getBest_ask() {
        return best_ask.toString();
    }

    public void setBest_ask(Object best_ask) {
        this.best_ask = best_ask;
    }
}
