package ru.itmatveev.xchanges.data.xchanges.exmo;

import lombok.Data;

@Data
public class ExmoTrades {
    private String pairName;
    private String tradeId;
    private String type;
    private String price;
    private String quantity;
    private String amount;
    private String date;

    public ExmoTrades() {
    }

    public ExmoTrades(String pairName, String tradeId, String type, String price, String quantity, String amount, String date) {
        this.pairName = pairName;
        this.tradeId = tradeId;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
