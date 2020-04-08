package com.example.info.controller;

import com.example.info.vo.DeBundle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * MyController:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 18:56
 */
@RestController
@CrossOrigin
public class MyController {
    /**
     * 初始化Key，返回key与对应验证码图片
     *
     * @return
     */
    @GetMapping("/init")
    public DeBundle init() {
        //生成key
        String key = String.valueOf(System.currentTimeMillis());
        //将key交给验证码服务端
        RestTemplate restTemplate = new RestTemplate();
        String picBase64 = restTemplate.getForObject("http://localhost:8096/generate/" + key, String.class);
        DeBundle deBundle = new DeBundle();
        deBundle.setKey(key);
        deBundle.setPicBase64(picBase64);
        return deBundle;
    }

    @GetMapping("/info/{key}/{value}/{phoneNumber}")
    public String getInfo(@PathVariable("key") String key, @PathVariable("value") String value, @PathVariable("phoneNumber") String phoneNumber) {
        //判断验证码是否正确
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject("http://localhost:8096/check/" + key + "/" + value, Boolean.class);
        //成功则返回电话号码的信息
        if (result) {


            return phoneNumber;
        } else {
            //错误则返回null；
            return null;
        }


    }
}
