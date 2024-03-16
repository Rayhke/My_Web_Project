package com.example.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/{id}")
    public String test(Model model) {
        System.out.println("");
        model.addAttribute("error", "임시");
        return "view";
    }
}
