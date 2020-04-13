package ru.itmatveev.xchanges.repo;

import org.springframework.stereotype.Repository;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveBidAsk;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveOrderBook;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveTicker;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveTrade;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
public class LiveCoinRepo {

    private LiveBidAsk bidAsk = new LiveBidAsk();
    private LiveOrderBook orderBook = new LiveOrderBook();

    private List<LiveTicker> tickerList = new ArrayList<>();

    private LiveTrade trade = new LiveTrade();

    public LiveBidAsk getBidAsk() {
        return bidAsk;
    }

    public LiveOrderBook getOrderBook() {
        return orderBook;
    }

    public List<LiveTicker> getTickerList() {
        return tickerList;
    }

    public LiveTicker getTickerListByPairName(String pairName) {
        for (LiveTicker liveTicker : tickerList) {
            if (liveTicker != null && liveTicker.getPairName().equals(pairName)) {
                return liveTicker;
            }
        }
        return null;
    }

    public LiveTicker getTickerListById(int id) {
        for (LiveTicker liveTicker : tickerList) {
            if (liveTicker != null && liveTicker.getId() == id) {
                return liveTicker;
            }
        }
        return null;
    }

    public void clearLiveCoinTickerList() {
        tickerList.clear();
    }

    public LiveTrade getTrade() {
        return trade;
    }


    public void addBidAsk(LiveBidAsk setBidAsk) {
        bidAsk = setBidAsk;
    }

//    public void addCoinInfo(LiveCoinInfo setCoinInfo){
//        jdbcTemplate.update(UPDATE_COININFO_LIVECOIN,
//                setCoinInfo.getName(),
//                setCoinInfo.getSymbol(),
//                setCoinInfo.getWalletStatus(),
//                setCoinInfo.getWithdrawFee(),
//                setCoinInfo.getMinDepositAmount(),
//                setCoinInfo.getMinWithdrawAmount());
//    }

    public void addOrderBook(LiveOrderBook setOrderBook) {
        orderBook = setOrderBook;
    }

    public void addTickerList(LiveTicker setTicker) {
        tickerList.add(setTicker);
    }

    public void addTrade(LiveTrade setTrade) {
        trade = setTrade;
    }


}
