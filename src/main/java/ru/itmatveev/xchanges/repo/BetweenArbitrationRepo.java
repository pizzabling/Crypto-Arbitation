package ru.itmatveev.xchanges.repo;

import org.springframework.stereotype.Repository;
import ru.itmatveev.xchanges.data.BetweenArbitration;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BetweenArbitrationRepo {
    private List<BetweenArbitration> betweenList = new ArrayList<>();

    public List<BetweenArbitration> getData(){
        return betweenList;
    }

    public BetweenArbitration getDataById(int id){
        for (BetweenArbitration betweenArbitration : betweenList){
            if (betweenArbitration != null && betweenArbitration.getId() == id){
                return betweenArbitration;
            }
        }
        return null;
    }

    public BetweenArbitration getDataByPairName(String pairName){
        for (BetweenArbitration betweenArbitration : betweenList){
            if(betweenArbitration != null && betweenArbitration.getPairName().equals(pairName)){
                return betweenArbitration;
            }
        }
        return null;
    }

    public void addData(BetweenArbitration data){
        betweenList.add(data);
    }

    public void clearList() {
        betweenList.clear();
    }
}
