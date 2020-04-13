package ru.itmatveev.xchanges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmatveev.xchanges.service.BetweenArbitrationCalcService;
import ru.itmatveev.xchanges.service.BetweenArbitrationService;
import ru.itmatveev.xchanges.service.FoundSamePairService;

@Controller
public class ArbitrationController {

    private BetweenArbitrationCalcService betweenArbitrationCalcService;
    private BetweenArbitrationService service;
    private FoundSamePairService samePairService;

    public ArbitrationController(BetweenArbitrationCalcService betweenArbitrationCalcService, BetweenArbitrationService service, FoundSamePairService samePairService) {
        this.betweenArbitrationCalcService = betweenArbitrationCalcService;
        this.service = service;
        this.samePairService = samePairService;
    }

    @GetMapping("/arbitration")
    public String betweenArbGet(Model model) throws Exception {
        samePairService.foundSamePair();
        model.addAttribute("data", service.getData());
        return "arbitration";
    }

    @PostMapping("/arbitration")
    public String betweenArbPost(@RequestParam String pairName, @RequestParam double transferFeeExmo,
                                 @RequestParam double transferFeeLiveCoin) {
        betweenArbitrationCalcService.calcPairArbitration(pairName, transferFeeExmo, transferFeeLiveCoin);
        return "arbitration";
    }
}
