package com.ruoxi.requestEntity;

import lombok.Data;

@Data
public class VerifyCodeRequest {
    private String phoneNumber;
    private String code;

}
