package com.code2go.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/managers")
    public String showManagers(){
        return "managers-home";
    }

    @GetMapping("/system")
    public String showSystem(){
        return "admin-home";
    }


}
