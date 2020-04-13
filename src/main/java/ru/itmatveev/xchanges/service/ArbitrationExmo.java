package ru.itmatveev.xchanges.service;

import org.springframework.stereotype.Service;
import ru.itmatveev.xchanges.repo.ExmoRepo;

@Service
public class ArbitrationExmo {
    private ExmoRepo repo;
    private PublicExmoService exmoService;

    public ArbitrationExmo(ExmoRepo repo, PublicExmoService exmoService) throws Exception {
        this.repo = repo;
        this.exmoService = exmoService;
    }


    public Object calcArbitrationExmo(){
        int lenght = exmoService.returnCount();

        //Перебор всех пар
        for (int i = 0; i < lenght; i++) {
            var pairFirst = repo.getExmoTickerListById(i);
            String pairName1 = pairFirst.getPairName();
            String cutName1Index1 = pairName1.split("_")[0];
            String cutName1Index2 = pairName1.substring(pairName1.lastIndexOf("_"));
            for (int k = 1; k < lenght; k++) {
                var pairSecond = repo.getExmoTickerListById(k);
                String pairName2 = pairSecond.getPairName();
                String cutName2Index1 = pairName2.split("_")[0];
                String cutName2Index2 = pairName2.substring(pairName2.lastIndexOf("_"));
                for (int j = 2; j < lenght; j++) {
                    var pairThird = repo.getExmoTickerListById(j);
                    String pairName3 = pairThird.getPairName();
                    String cutName3Index1 = pairName3.split("_")[0];
                    String cutName3Index2 = pairName3.substring(pairName3.lastIndexOf("_"));
                    //Логика нахождения арбитражных пар
                    if (cutName1Index1.equals(cutName3Index2) & cutName1Index2.equals(cutName2Index2) & cutName2Index1.equals(cutName3Index1)) {
                        System.out.println("Найдена арбитражная пара, высчитываем прибыль");
                        double buyPrice1 = Double.parseDouble(pairFirst.getBuyPrice());
                        double sellPrice2 = Double.parseDouble(pairSecond.getSellPrice());
                        double buyPrice3 = Double.parseDouble(pairSecond.getBuyPrice());

                        double resultOneToTwo = buyPrice1 / sellPrice2;
                        double resultTwoToThree = resultOneToTwo / buyPrice3;

                        double profit = buyPrice1 - resultTwoToThree;

                        if (profit > buyPrice1) {
                            System.out.println(pairName1 + ": " + buyPrice1);
                            System.out.println(pairName2 + ": " + sellPrice2);
                            System.out.println(pairName3 + ": " + buyPrice3);
                            System.out.println("Профит= " + profit + " " + cutName1Index1);
                        }
                    }
                }
            }
        }
        return null;
    }
}
