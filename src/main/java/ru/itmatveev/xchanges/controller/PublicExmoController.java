package ru.itmatveev.xchanges.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmatveev.xchanges.service.ArbitrationExmo;
import ru.itmatveev.xchanges.service.PublicExmoService;

@Controller

public class PublicExmoController {

    private PublicExmoService exmoService;
    private ArbitrationExmo arbExmo;

    public PublicExmoController(PublicExmoService exmoService, ArbitrationExmo arbExmo) {
        this.exmoService = exmoService;
        this.arbExmo = arbExmo;
    }

    @GetMapping("/exmo")
    public String exmoPageGet(Model model) throws Exception {
        model.addAttribute("trades", exmoService.getExmoTradesInfo());
        model.addAttribute("order", exmoService.getExmoOrderBookInfo());
        model.addAttribute("ticker", exmoService.getExmoTickerList());
        model.addAttribute("settings", exmoService.getExmoPairSettings());
        return "exmo";
    }

    @PostMapping("/exmo")
    public String exmoPagePost() throws Exception {
//        exmoService.addPair("BTC_USD");
        exmoService.parseExmoTicker();
//        arbExmo.calcArbitrationExmo();
        return "exmo";
    }

    @GetMapping("/arb")
    public String exmoArbitration() throws Exception{
        return ("/arb");
    }
    @PostMapping("/arb")
    public String exmoArb() throws Exception {
        arbExmo.calcArbitrationExmo();
        return ("/arb");
    }


}
