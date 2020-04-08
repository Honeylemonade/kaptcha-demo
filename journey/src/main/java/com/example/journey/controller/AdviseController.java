package com.example.journey.controller;

import com.example.journey.service.AdviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherController:
 *
 * @Author XvYanpeng
 * @Date 2020/4/4 21:12
 */
@CrossOrigin
@RestController
public class AdviseController {
    @Autowired
    AdviseService adviseService;

    @GetMapping("/advise/{userName}/{myDate}")
    public Integer getWeather(@PathVariable("userName") String userName, @PathVariable("myDate") String myDate) {
        Integer result = adviseService.getAdvise(userName, myDate);
        return result;
    }

}
