package ru.itmatveev.xchanges.service;

import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.BetweenArbitration;
import ru.itmatveev.xchanges.repo.BetweenArbitrationRepo;

import java.util.List;

@Service
public class BetweenArbitrationService {

    private BetweenArbitrationRepo repo;
    private int id = 0;

    public BetweenArbitrationService(BetweenArbitrationRepo repo) {
        this.repo = repo;
    }

    public List<BetweenArbitration> getData(){
        return repo.getData();
    }

    public BetweenArbitration getDataById(int id){
        return repo.getDataById(id);
    }

    public BetweenArbitration getDataByPairName(String pairName){
        return repo.getDataByPairName(pairName);
    }

    public void addData(String pairName, String whereFrom, String whereTo, double result, double profit){
        BetweenArbitration data = new BetweenArbitration(id,pairName, whereFrom, whereTo, result, profit);
        repo.addData(data);
        id = id + 1;
    }

    public void clearList(){
        repo.clearList();
        id = 0;
    }
}
