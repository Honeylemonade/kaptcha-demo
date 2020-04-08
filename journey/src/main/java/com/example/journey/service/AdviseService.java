package com.example.journey.service;

import com.example.journey.dto.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * AdviseService:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 10:51
 */
@Service
public class AdviseService {
    public Integer getAdvise(String userName, String myDate) {
        System.out.println(userName);
        System.out.println(myDate);
        //调用开支服务
        RestTemplate restTemplate = new RestTemplate();
        String savingUrl = "http://localhost:8090/bankSaving/" + userName;
        int bankSaving = restTemplate.getForObject(savingUrl, Integer.class);
        return bankSaving;
    }
}
