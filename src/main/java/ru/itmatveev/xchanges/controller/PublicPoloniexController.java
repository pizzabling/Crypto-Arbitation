package ru.itmatveev.xchanges.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmatveev.xchanges.service.PublicPoloniexService;

@Controller
public class PublicPoloniexController {
    private PublicPoloniexService service;

    public PublicPoloniexController(PublicPoloniexService service) {
        this.service = service;
    }

    @GetMapping("/poloniex")
    public String poloniexPageGet(Model model){
        model.addAttribute("ticker",service.getPoloniexTickerList());
        return "poloniex";
    }

    @PostMapping("/poloniex")
    public String parsePoloniexTicker() throws Exception{
        service.parsePoloniexTickerList();
        return "poloniex";
    }
}
