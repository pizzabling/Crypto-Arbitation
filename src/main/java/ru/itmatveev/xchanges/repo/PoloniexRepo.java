package ru.itmatveev.xchanges.repo;

import org.springframework.stereotype.Repository;
import ru.itmatveev.xchanges.data.xchanges.poloniex.PoloniexTicker;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PoloniexRepo {
    private List<PoloniexTicker> tickerList = new ArrayList<>();

    public List<PoloniexTicker> getPoloniexTickerList() {
        return tickerList;
    }

    public PoloniexTicker getPoloniexTickerListByPairName(String pairName) {
        for (PoloniexTicker poloniexTicker : tickerList) {
            if (poloniexTicker != null && poloniexTicker.getPairName().equals(pairName)) {
                return poloniexTicker;
            }
        }
        return null;
    }

    public PoloniexTicker getPoloniexTickerListById(int id) {
        for (PoloniexTicker poloniexTicker : tickerList) {
            if (poloniexTicker != null && poloniexTicker.getId() == id) {
                return poloniexTicker;
            }
        }
        return null;
    }

    public void addPoloniexTickerList(PoloniexTicker ticker) {
        tickerList.add(ticker);
    }

    public void clearTickerList(){
        tickerList.clear();
    }

}
