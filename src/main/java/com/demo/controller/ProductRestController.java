package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @GetMapping("/")
    public String getApplicatinInfo(){
        return "This is Spring boot Junit Application";
    }
}
