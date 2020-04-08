package com.example.expenditure.controller;

import com.example.expenditure.vo.UserCount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * UserCountController:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 9:59
 */
@RestController
public class UserCountController {
    @GetMapping("/bankSaving/{userName}")
    public int getAllUserCounts(@PathVariable("userName") String userName) {
        ArrayList<UserCount> arrayList = new ArrayList<>();
        arrayList.add(new UserCount("1", 2330));
        arrayList.add(new UserCount("2", 2440));
        arrayList.add(new UserCount("3", 2550));
        arrayList.add(new UserCount("4", 2230));
        arrayList.add(new UserCount("5", 2120));
        arrayList.add(new UserCount("6", 230));
        arrayList.add(new UserCount("7", 120));
        arrayList.add(new UserCount("zxcasdqwe", 420));
        for (UserCount u : arrayList) {
            if (u.getUserName().equals(userName)) {
                return u.getBankSavings();
            }
        }
        return 0;
    }
}
