package com.epam.wtf.controller;

import com.epam.wtf.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private CatService catService;

    public AppController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping("/")
    public String getStatus(Model model) {
        model.addAttribute("hello", "I am ok!");
        return "hello";
    }

    @RequestMapping("/wtf")
    public String getWtf(Model model) {
        model.addAttribute("wtf", catService.add(15.0, 22.0));
        return "wtf";
    }
}
