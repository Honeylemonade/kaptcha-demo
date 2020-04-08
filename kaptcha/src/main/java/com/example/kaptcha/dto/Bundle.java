package com.example.kaptcha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * keyMapper:
 *
 * @Author XvYanpeng
 * @Date 2020/4/8 19:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bundle {
    String key;
    String value;
    String picBase64;
}
