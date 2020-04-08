package com.example.journey.dto;

import java.util.List;

/**
 * HeWeather6:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 14:25
 */
public class HeWeather6 {
    private Basic basic;

    private Update update;

    private String status;

    private List<Daily_forecast> daily_forecast;

    public void setBasic(Basic basic){
        this.basic = basic;
    }
    public Basic getBasic(){
        return this.basic;
    }
    public void setUpdate(Update update){
        this.update = update;
    }
    public Update getUpdate(){
        return this.update;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setDaily_forecast(List<Daily_forecast> daily_forecast){
        this.daily_forecast = daily_forecast;
    }
    public List<Daily_forecast> getDaily_forecast(){
        return this.daily_forecast;
    }
}
