package com.ruoxi.Controller;

import com.ruoxi.Service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {
    @Autowired
    private VerificationService verificationService;
    @GetMapping("/verification-code")
    public String verify() {
        return "Verification successful";
    }
}
