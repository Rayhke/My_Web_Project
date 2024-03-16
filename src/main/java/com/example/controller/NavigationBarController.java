package com.example.controller;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class NavigationBarController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}