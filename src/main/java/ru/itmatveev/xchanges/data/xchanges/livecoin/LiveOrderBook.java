package ru.itmatveev.xchanges.data.xchanges.livecoin;

import lombok.Data;

@Data
public class LiveOrderBook {
    private String pairName;
    private String timestamp;
    private String asks;
    private String bids;

    public LiveOrderBook() {
    }

    public LiveOrderBook(String pairName, String timestamp, String asks, String bids) {
        this.pairName = pairName;
        this.timestamp = timestamp;
        this.asks = asks;
        this.bids = bids;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAsks() {
        return asks;
    }

    public void setAsks(String asks) {
        this.asks = asks;
    }

    public String getBids() {
        return bids;
    }

    public void setBids(String bids) {
        this.bids = bids;
    }
}
