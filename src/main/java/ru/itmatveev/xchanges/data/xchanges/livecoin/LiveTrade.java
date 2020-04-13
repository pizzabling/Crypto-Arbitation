package ru.itmatveev.xchanges.data.xchanges.livecoin;

import lombok.Data;

@Data
public class LiveTrade {
    private String pairName;
    private String time;
    private String id;
    private String price;
    private String quantity;
    private String type;

    public LiveTrade() {
    }

    public LiveTrade(String pairName, String time, String id, String price, String quantity, String type) {
        this.pairName = pairName;
        this.time = time;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
