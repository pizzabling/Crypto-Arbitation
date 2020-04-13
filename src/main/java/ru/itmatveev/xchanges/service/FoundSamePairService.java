package ru.itmatveev.xchanges.service;

import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.data.FoundSamePairs;
import ru.itmatveev.xchanges.data.xchanges.exmo.ExmoTicker;
import ru.itmatveev.xchanges.data.xchanges.livecoin.LiveTicker;
import ru.itmatveev.xchanges.repo.FoundSamePairRepo;

import java.util.List;

@Service
public class FoundSamePairService {
    private FoundSamePairRepo repo;
    private PublicExmoService exmoService;
    private PublicLiveCoinService liveCoinService;
    private BetweenArbitrationCalcService betweenCalcService;
    private BetweenArbitrationService betweenService;


    public FoundSamePairService(FoundSamePairRepo repo, PublicExmoService exmoService, PublicLiveCoinService liveCoinService, BetweenArbitrationCalcService betweenCalcService, BetweenArbitrationService betweenService) {
        this.repo = repo;
        this.exmoService = exmoService;
        this.liveCoinService = liveCoinService;
        this.betweenCalcService = betweenCalcService;
        this.betweenService = betweenService;
    }

    public List<FoundSamePairs> getSamePairs() {
        return repo.getSamePairs();
    }

    public void saveSamePairs(FoundSamePairs data) {
        repo.saveSamePairs(data);
    }

    public void clearSamePairs() {
        repo.clearSamePairs();
    }

    public void foundSamePair() throws Exception {
        betweenService.clearList();

        int lengthExmoData = exmoService.returnCount();
        int lengthLiveCoinData = liveCoinService.returnCount();

        for (int i = 0; i < lengthExmoData; i++) {
            var exmo = exmoService.getExmoTickerList();
            ExmoTicker getAsListExmo = exmo.get(i);
            String pairNameExmo = getAsListExmo.getPairName();

            for (int j = 0; j < lengthLiveCoinData; j++) {
                var liveCoin = liveCoinService.getTickerInfo();
                LiveTicker getasListLiveCoin = liveCoin.get(j);
                String pairNameLiveCoin = getasListLiveCoin.getPairName();

                if (pairNameExmo.equals(pairNameLiveCoin)) {
                    FoundSamePairs data = new FoundSamePairs(pairNameExmo);
                    saveSamePairs(data);
                    betweenCalcService.calcPairArbitration(pairNameExmo, 0, 0);
                }
            }
        }
    }
}
