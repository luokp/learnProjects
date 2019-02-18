package com.luokp.springbootcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping("/")
//    public String index(){
//        return "login";
//    }
    @RequestMapping("hello")
    public String hello(){
        return "hello world21212121!";
    }
}
