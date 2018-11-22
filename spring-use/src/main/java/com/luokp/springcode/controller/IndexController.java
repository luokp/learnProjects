package com.luokp.springcode.controller;

import com.luokp.springcode.Define_annotation_aspect.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @MyLog(requestUrl = "请求index.html")
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
