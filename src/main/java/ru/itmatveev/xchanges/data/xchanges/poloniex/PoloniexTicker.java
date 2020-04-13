package ru.itmatveev.xchanges.data.xchanges.poloniex;

import lombok.Data;

@Data
public class PoloniexTicker {
    private int id;
    private String pairName;
    private String last;
    //Покупаем по цене
    private String lowestAsk;
    //Продаём по цене
    private String highestBid;
    //Процент изменения цены
    private String percentChange;
    //Объём за 24 часа
    private String baseVolume;
    //Котируемый объём за 24 часа
    private String quoteVolume;
    //Заморожена ли торговля
    private String isFrozen;
    //Хай цена за 24 часа
    private String high;
    //Лоу цена за 24 часа
    private String low;

    public PoloniexTicker(int id, String pairName, String last, String lowestAsk, String highestBid, String percentChange, String baseVolume, String quoteVolume, String isFrozen, String high, String low) {
        this.id = id;
        this.pairName = pairName;
        this.last = last;
        this.lowestAsk = lowestAsk;
        this.highestBid = highestBid;
        this.percentChange = percentChange;
        this.baseVolume = baseVolume;
        this.quoteVolume = quoteVolume;
        this.isFrozen = isFrozen;
        this.high = high;
        this.low = low;
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
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(String isFrozen) {
        this.isFrozen = isFrozen;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
