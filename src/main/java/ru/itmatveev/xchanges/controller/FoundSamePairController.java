package ru.itmatveev.xchanges.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmatveev.xchanges.service.ArbitrationExmo;
import ru.itmatveev.xchanges.service.FoundSamePairService;

@Controller
public class FoundSamePairController {
    private FoundSamePairService service;
    private ArbitrationExmo exmo;


    public FoundSamePairController(FoundSamePairService service, ArbitrationExmo exmo) {
        this.service = service;
        this.exmo = exmo;
    }

    @GetMapping("/samePairs")
    public String getSamePairs(Model model) throws Exception {
        service.foundSamePair();
        model.addAttribute("data", service.getSamePairs());
        return "samePairs";
    }
}
