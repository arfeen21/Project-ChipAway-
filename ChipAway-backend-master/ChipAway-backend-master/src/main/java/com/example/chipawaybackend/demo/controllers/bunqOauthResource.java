package com.example.chipawaybackend.demo.controllers;

import org.springframework.web.bind.annotation.*;


@RestController
public class bunqOauthResource {

    @GetMapping("/oauth")
    @ResponseBody
    public void getOauth(@RequestParam String code) {

        System.out.println(code);



    }

}
