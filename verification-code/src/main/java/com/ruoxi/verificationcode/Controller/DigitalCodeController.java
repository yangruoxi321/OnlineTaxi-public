package com.ruoxi.verificationcode.Controller;

import datatoobject.ResponseResult;
import response.DigitalCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DigitalCodeController {
    @GetMapping("/digitalCode")
//    public String digitalCode(@RequestParam("size") int size){
//        System.out.println("size = " + size);
//        JSONObject result = new JSONObject();
//        result.put("code","201");
//        result.put("message","success");
//        JSONObject payload = new JSONObject();
//        payload.put("digitalCode","123456");
//        result.put("payload",payload);
//        return result.toString();
//    }
    public ResponseResult <DigitalCodeResponse> digitalCode(@RequestParam("size") int size){
        DigitalCodeResponse digitalCodeResponse = new DigitalCodeResponse();
        digitalCodeResponse.setDigitalCode(generateCode(size));
        return ResponseResult.success(digitalCodeResponse);
    }
    private int generateCode(int size){
        return (int) ((Math.random()*8 + 1) * Math.pow(10, size - 1));
    }
}
