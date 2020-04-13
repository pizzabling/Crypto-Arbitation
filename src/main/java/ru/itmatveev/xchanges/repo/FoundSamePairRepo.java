package ru.itmatveev.xchanges.repo;

import org.springframework.stereotype.Repository;
import ru.itmatveev.xchanges.data.FoundSamePairs;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoundSamePairRepo {

    private List<FoundSamePairs> samePairs = new ArrayList<>();

    public List<FoundSamePairs> getSamePairs(){
        return samePairs;
    }

    public void saveSamePairs(FoundSamePairs data){
        samePairs.add(data);
    }

    public void clearSamePairs(){
        samePairs.clear();
    }
}
