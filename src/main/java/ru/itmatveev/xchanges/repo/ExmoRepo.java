package ru.itmatveev.xchanges.repo;

import org.springframework.stereotype.Repository;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoOrderBook;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoPairSettings;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoTicker;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoTrades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ExmoRepo {
    private List<ExmoTicker> tickerList = new ArrayList<>();

    private List<ExmoPairSettings> pairSettingsList = new ArrayList<>();
    private ExmoTrades trades = new ExmoTrades();
    private ExmoOrderBook orderBook = new ExmoOrderBook();

    public List<ExmoTicker> getExmoTickerList() {
        return tickerList;
    }

    public ExmoTicker getExmoTickerListById(int id) {
        for (ExmoTicker exmoTicker : tickerList) {
            if (exmoTicker != null && exmoTicker.getId() == id) {
                return exmoTicker;
            }
        }
        return null;
    }

    public ExmoTicker getExmoTickerListByPairName(String pairName) {
        for (ExmoTicker exmoTicker : tickerList) {
            if (exmoTicker != null && exmoTicker.getPairName().equals(pairName)) {
                return exmoTicker;
            }
        }
        return null;
    }

    public List<ExmoPairSettings> getExmoPairSettings() {
        return pairSettingsList;
    }

    public ExmoTrades getTradesInfo() {
        return trades;
    }

    public ExmoOrderBook getOrderBookInfo() {
        return orderBook;
    }

    public void addExmoPairSettings(ExmoPairSettings pairSettings) {
        pairSettingsList.add(pairSettings);
    }

    public void addExmoTickerList(ExmoTicker tickers) {
        tickerList.add(tickers);
    }

    public void clearExmoTickerList() {
        tickerList.clear();
    }

    public void addTradesInfo(ExmoTrades setTrades) {
        trades = setTrades;
    }

    public void addOrderBookInfo(ExmoOrderBook setOrderBook) {
        orderBook = setOrderBook;
    }
}
