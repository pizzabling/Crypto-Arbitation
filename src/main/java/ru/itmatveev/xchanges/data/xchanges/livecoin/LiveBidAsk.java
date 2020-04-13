package ru.itmatveev.xchanges.data.xchanges.livecoin;

import lombok.Data;

@Data
public class LiveBidAsk {
    private String pairName;
    private String maxBid;
    private String minAsk;

    public LiveBidAsk() {
    }

    public LiveBidAsk(String pairName, String maxBid, String minAsk) {
        this.pairName = pairName;
        this.maxBid = maxBid;
        this.minAsk = minAsk;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(String maxBid) {
        this.maxBid = maxBid;
    }

    public String getMinAsk() {
        return minAsk;
    }

    public void setMinAsk(String minAsk) {
        this.minAsk = minAsk;
    }
}
