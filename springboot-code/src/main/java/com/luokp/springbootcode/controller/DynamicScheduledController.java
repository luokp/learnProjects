package com.luokp.springbootcode.controller;

import com.luokp.springbootcode.service.ScheduledForDynamicCron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luokp
 * @date: 2019/4/22 15:35
 * @description:
 */
@RestController
@RequestMapping("/scheduled")
public class DynamicScheduledController {


    @Autowired
    ScheduledForDynamicCron scheduledForDynamicCron;

    @RequestMapping(value = "/update-cron")
    public String updateDynamicScheduledTask(@RequestParam("cron") String cron) {

        scheduledForDynamicCron.setCron(cron);

        return "success";
    }
}
