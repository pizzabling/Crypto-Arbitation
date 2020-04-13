package ru.itmatveev.xchanges.data.xchanges.exmo;

import lombok.Data;

@Data
public class ExmoOrderBook {
    private String pairName;
    private String ask_quantity;
    private String aks_amount;
    private String aks_top;
    private String bid_quantity;
    private String bid_amount;
    private String bid_top;
    private String ask;
    private String bid;

    public ExmoOrderBook() {
    }

    public ExmoOrderBook(String pairName, String ask_quantity, String aks_amount, String aks_top, String bid_quantity, String bid_amount, String bid_top, String ask, String bid) {
        this.pairName = pairName;
        this.ask_quantity = ask_quantity;
        this.aks_amount = aks_amount;
        this.aks_top = aks_top;
        this.bid_quantity = bid_quantity;
        this.bid_amount = bid_amount;
        this.bid_top = bid_top;
        this.ask = ask;
        this.bid = bid;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getAsk_quantity() {
        return ask_quantity;
    }

    public void setAsk_quantity(String ask_quantity) {
        this.ask_quantity = ask_quantity;
    }

    public String getAks_amount() {
        return aks_amount;
    }

    public void setAks_amount(String aks_amount) {
        this.aks_amount = aks_amount;
    }

    public String getAks_top() {
        return aks_top;
    }

    public void setAks_top(String aks_top) {
        this.aks_top = aks_top;
    }

    public String getBid_quantity() {
        return bid_quantity;
    }

    public void setBid_quantity(String bid_quantity) {
        this.bid_quantity = bid_quantity;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    public void setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
    }

    public String getBid_top() {
        return bid_top;
    }

    public void setBid_top(String bid_top) {
        this.bid_top = bid_top;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
