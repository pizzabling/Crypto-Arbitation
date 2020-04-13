package ru.itmatveev.xchanges.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmatveev.xchanges.service.PublicLiveCoinService;

@Controller

public class PublicLiveCoinController {
    private PublicLiveCoinService liveCoinService;

    public PublicLiveCoinController(PublicLiveCoinService liveCoinService) {
        this.liveCoinService = liveCoinService;
    }

    @GetMapping("/livecoin")
    public String livecoinPageGet(Model model){
        model.addAttribute("ticker",liveCoinService.getTickerInfo());
        model.addAttribute("trade",liveCoinService.getTradeInfo());
        model.addAttribute("bidask",liveCoinService.getBidAskInfo());
        model.addAttribute("orderbook",liveCoinService.getOrderBookInfo());
        return "livecoin";
    }

    @PostMapping("/livecoin")
    public String livecoinPagePost() throws Exception {
        liveCoinService.parseTickerList();
        return "livecoin";
    }
}
