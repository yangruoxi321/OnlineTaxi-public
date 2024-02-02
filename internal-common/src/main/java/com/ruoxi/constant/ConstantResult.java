package com.ruoxi.constant;

import lombok.Getter;

@Getter
public enum ConstantResult {
    SUCCESS(201,"success"),
    FAIL(0,"fail")
    ;
    private int code;
    private String message;

    ConstantResult(int code, String message){
        this.code = code;
        this.message = message;
    }
}
