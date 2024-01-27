package com.ruoxi.Controller;

import com.ruoxi.Service.VerificationService;
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
   public String VerifyCode(@RequestBody getRequest request){
        String phoneNumber = request.getPhoneNumber();
        int a = 1;
        return verificationService.generateCode(phoneNumber);
    }
}
