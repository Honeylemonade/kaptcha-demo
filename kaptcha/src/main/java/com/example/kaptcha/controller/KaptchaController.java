package com.example.kaptcha.controller;

import com.example.kaptcha.dto.Bundle;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

/**
 * KaptchaController:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 16:47
 */
@CrossOrigin
@RestController
@Slf4j
public class KaptchaController {

    public static ArrayList<Bundle> bundleArrayList = new ArrayList<>();

    @Autowired
    private DefaultKaptcha captchaProducer;


    @GetMapping("/generate/{key}")
    public String generate(@PathVariable("key") String key) throws IOException {
        Bundle bundle = new Bundle();

        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        // create the image with the text
        BufferedImage bufferedImage = captchaProducer.createImage(capText);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", stream);
        String picBase64 = new String(Base64Utils.encode(stream.toByteArray()), "UTF-8");
        bundle.setKey(key);
        bundle.setValue(capText);
        bundle.setPicBase64(picBase64);

        log.info("******************key是: " + key + "******************");
        log.info("******************验证码是: " + capText + "******************");
        log.info("******************picBase64是: " + picBase64 + "******************");
        bundleArrayList.add(bundle);
        return picBase64;
    }

    @GetMapping("/check/{key}/{value}")
    public boolean check(@PathVariable("key") String key, @PathVariable("value") String value) {
        for (Bundle b : bundleArrayList) {
            if (b.getKey().equals(key) && b.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
