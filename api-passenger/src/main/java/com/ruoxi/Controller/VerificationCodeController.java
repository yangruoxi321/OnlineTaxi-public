package com.ruoxi.Controller;

import com.ruoxi.Service.VerificationService;
import com.ruoxi.datatoobject.ResponseResult;
import com.ruoxi.requestEntity.VerifyCodeRequest;
import com.ruoxi.requestEntity.getRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationService verificationService;
    @GetMapping("/verification-code")
    public ResponseResult VerificationCode(@RequestBody getRequest request){
        String phoneNumber = request.getPhoneNumber();
        return verificationService.generateVerificationCode(phoneNumber);
    }
    @GetMapping("/verify-code")
    public ResponseResult VerifyCode(@RequestBody VerifyCodeRequest verifyCodeRequest){
        return verificationService.verifyCode(verifyCodeRequest.getPhoneNumber(),verifyCodeRequest.getCode());

    }
}

