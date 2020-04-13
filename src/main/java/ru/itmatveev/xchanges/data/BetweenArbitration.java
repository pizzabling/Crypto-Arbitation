package ru.itmatveev.xchanges.data;

import lombok.Data;

@Data
public class BetweenArbitration {
    private int id;
    //Пара в форме PAIR1/PAIR2
    private String pairName;
    //Где покупаем
    private String whereFrom;
    //Где продаём
    private String whereTo;
    //Результат, если нет выгодной арбитражной ситуации
    private double result;
    //Результат, если нашлась выгодная арбитражная ситуация
    private double profit;

    public BetweenArbitration() {
    }

    public BetweenArbitration(int id,String pairName, String whereFrom, String whereTo, double result, double profit) {
        this.id = id;
        this.pairName = pairName;
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.result = result;
        this.profit = profit;
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

    public String getWhereFrom(){
        return whereFrom;
    }

    public void setWhereFrom(){
        this.whereFrom = whereFrom;
    }

    public String getWhereTo(){
        return whereTo;
    }

    public void setWhereTo(){
        this.whereTo = whereTo;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
