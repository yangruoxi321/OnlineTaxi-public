package com.ruoxi;

import lombok.Getter;

@Getter
public enum ConstantResult {
    SUCCESS(201,"success"),
    FAIL(0,"fail"),
    VERIFICATION_ERROR(1099,"Verification code error.")
    ;
    private int code;
    private String message;

    ConstantResult(int code, String message){
        this.code = code;
        this.message = message;
    }
}
