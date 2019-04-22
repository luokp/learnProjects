package com.luokp.authweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: luokp
 * @date: 2019/4/12 22:11
 * @description:
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/helloC")
    public String helloC() {
        System.out.println("sf");
        String s= restTemplate.getForObject("http://localhost:8083/hello", String.class);
        return s;
    }

}
