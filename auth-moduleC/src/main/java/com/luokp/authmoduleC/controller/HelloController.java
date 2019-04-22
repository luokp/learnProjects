package com.luokp.authmoduleC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luokp
 * @date: 2019/4/12 22:11
 * @description:
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "helloC";
    }
}
