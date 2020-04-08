package com.example.journey.dto;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Update:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 14:21
 */
public class Update {
    private Date loc;

    private Date utc;

    public void setLoc(Date loc){
        this.loc = loc;
    }
    public Date getLoc(){
        return this.loc;
    }
    public void setUtc(Date utc){
        this.utc = utc;
    }
    public Date getUtc(){
        return this.utc;
    }
}
