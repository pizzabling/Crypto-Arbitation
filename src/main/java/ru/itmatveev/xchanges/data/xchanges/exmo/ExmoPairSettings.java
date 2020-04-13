package ru.itmatveev.xchanges.data.xchanges.exmo;

import lombok.Data;

@Data
public class ExmoPairSettings {
    private String pairName;
    //Минимальное кол-во по ордеру
    private String min_quantity;
    //Максимальное кол-во по ордеру
    private String max_quantity;
    //Минимальная цена по ордеру
    private String min_price;
    //Максимальная цена по ордеру
    private String max_price;
    //Минимальная сумма по ордеру
    private String min_amount;
    //Максимальная сумма по ордеру
    private String max_amount;

    public ExmoPairSettings() {
    }

    public ExmoPairSettings(String pairName, String min_quantity, String max_quantity, String min_price, String max_price, String min_amount, String max_amount) {
        this.pairName = pairName;
        this.min_quantity = min_quantity;
        this.max_quantity = max_quantity;
        this.min_price = min_price;
        this.max_price = max_price;
        this.min_amount = min_amount;
        this.max_amount = max_amount;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getMin_quantity() {
        return min_quantity;
    }

    public void setMin_quantity(String min_quantity) {
        this.min_quantity = min_quantity;
    }

    public String getMax_quantity() {
        return max_quantity;
    }

    public void setMax_quantity(String max_quantity) {
        this.max_quantity = max_quantity;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getMin_amount() {
        return min_amount;
    }

    public void setMin_amount(String min_amount) {
        this.min_amount = min_amount;
    }

    public String getMax_amount() {
        return max_amount;
    }

    public void setMax_amount(String max_amount) {
        this.max_amount = max_amount;
    }
}
