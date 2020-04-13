package ru.itmatveev.xchanges.data.xchanges.exmo;

import lombok.Data;

@Data
public class ExmoTicker {
    private int id;
    //Название пары
    private String pairName;
    //Текущая максимальная цена покупки
    private String buyPrice;
    //Текущая максимальная цена продажи
    private String sellPrice;
    //Цена последней сделки
    private String lastTrade;
    //Максимальная цена сделки за 24 часа
    private String high;
    //Минимальная цена сделки за 24 часа
    private String low;
    //Средняя цена сделки за 24 часа
    private String avg;
    //Объём всех сделок за 24 часа
    private String vol;
    //Сумма всех сделок за 24 часа
    private String vol_curr;
    //Дата и время обновления данных
    private String updated;

    public ExmoTicker(int id, String pairName, String buyPrice, String sellPrice, String lastTrade, String high, String low, String avg, String vol, String vol_curr) {
        this.id = id;
        this.pairName = pairName;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.lastTrade = lastTrade;
        this.high = high;
        this.low = low;
        this.avg = avg;
        this.vol = vol;
        this.vol_curr = vol_curr;
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

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(String lastTrade) {
        this.lastTrade = lastTrade;
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

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getVol_curr() {
        return vol_curr;
    }

    public void setVol_curr(String vol_curr) {
        this.vol_curr = vol_curr;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
