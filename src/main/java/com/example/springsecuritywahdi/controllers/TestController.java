package com.example.springsecuritywahdi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test1")
    public String testfunction()
    {
        return "OK";
    }



}
