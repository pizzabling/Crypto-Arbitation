package ru.itmatveev.xchanges.service;

import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.BetweenArbitration;
import ru.itmatveev.xchanges.repo.ExmoRepo;
import ru.itmatveev.xchanges.repo.LiveCoinRepo;

@Service
public class BetweenArbitrationCalcService {
    private ExmoRepo exmoRepo;
    private LiveCoinRepo liveCoinRepo;
    private BetweenArbitrationService service;


    public BetweenArbitrationCalcService(ExmoRepo exmoRepo, LiveCoinRepo liveCoinRepo, BetweenArbitrationService service) {
        this.exmoRepo = exmoRepo;
        this.liveCoinRepo = liveCoinRepo;
        this.service = service;
    }

    public void calcPairArbitration(String pairName, double transferFeeExmo, double transferFeeLiveCoin) {
        var pairNameExmo = exmoRepo.getExmoTickerListByPairName(pairName);
        var pairNameLiveCoin = liveCoinRepo.getTickerListByPairName(pairName);

        String whereFrom;
        String whereTo;

        double liveCoinFee = 0.18;
        double exmoFee = 0.2;

        double profit;
        double result = 0;
        //sell - ask, цена, за которую покупаем мы
        //buy - bid, цена, за которую продаём мы
        double sellPriceExmo = Double.parseDouble(pairNameExmo.getSellPrice());
        double buyPriceExmo = Double.parseDouble(pairNameExmo.getBuyPrice());
        double sellPriceLiveCoin = Double.parseDouble(pairNameLiveCoin.getBest_ask());
        double buyPriceLiveCoin = Double.parseDouble(pairNameLiveCoin.getBest_bid());

        //Расчёт комиссий внутри Exmo при покупке/продаже
        double sellPriceExmoWithFee = sellPriceExmo - ((sellPriceExmo * exmoFee) / 100);
        double buyPriceExmoWithFee = buyPriceExmo - ((buyPriceExmo * exmoFee) / 100);
        //Расчёт комиссий при переводе с Exmo. incomingCoin - число монет, поступившая на биржу с вычетом комиссий при переводе
        double incomingCoinExmo = 1 - transferFeeExmo;
        double buyPriceExmoIncoming = buyPriceExmoWithFee * incomingCoinExmo;
        //Расчёт комиссий внутри LiveCoin при покупке/продаже
        double sellPriceLiveCoinWithFee = sellPriceLiveCoin - ((sellPriceLiveCoin * liveCoinFee) / 100);
        double buyPriceLiveCoinWithFee = buyPriceLiveCoin - ((buyPriceLiveCoin * liveCoinFee) / 100);
        //Расчёт комиссий при переводе с LiveCoin
        double incomingCoinLiveCoin = 1 - transferFeeLiveCoin;
        double buyPriceLiveCoinIncoming = buyPriceLiveCoinWithFee * incomingCoinLiveCoin;

        if (sellPriceExmoWithFee < buyPriceLiveCoinIncoming) {
            //Рачитываем прибыль
            profit = buyPriceLiveCoin - sellPriceExmo;
            whereFrom = "EXMO";
            whereTo = "LiveCoin";
            service.addData(pairName, whereFrom, whereTo, result, profit);
        } else if (sellPriceLiveCoinWithFee < buyPriceExmoIncoming) {
            profit = buyPriceExmo - sellPriceLiveCoin;
            whereFrom = "LiveCoin";
            whereTo = "EXMO";
            service.addData(pairName, whereFrom, whereTo, result, profit);
        }
    }
}


