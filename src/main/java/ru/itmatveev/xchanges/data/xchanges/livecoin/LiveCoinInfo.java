package ru.itmatveev.xchanges.data.xchanges.livecoin;

import lombok.Data;

@Data
public class LiveCoinInfo {
    private String name;
    private String symbol;
    private String walletStatus;
    private String withdrawFee;
    private String minDepositAmount;
    private String minWithdrawAmount;

    public LiveCoinInfo() {
    }

    public LiveCoinInfo(String name, String symbol, String walletStatus, String withdrawFee, String minDepositAmount, String minWithdrawAmount) {
        this.name = name;
        this.symbol = symbol;
        this.walletStatus = walletStatus;
        this.withdrawFee = withdrawFee;
        this.minDepositAmount = minDepositAmount;
        this.minWithdrawAmount = minWithdrawAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(String walletStatus) {
        this.walletStatus = walletStatus;
    }

    public String getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(String withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getMinDepositAmount() {
        return minDepositAmount;
    }

    public void setMinDepositAmount(String minDepositAmount) {
        this.minDepositAmount = minDepositAmount;
    }

    public String getMinWithdrawAmount() {
        return minWithdrawAmount;
    }

    public void setMinWithdrawAmount(String minWithdrawAmount) {
        this.minWithdrawAmount = minWithdrawAmount;
    }
}
