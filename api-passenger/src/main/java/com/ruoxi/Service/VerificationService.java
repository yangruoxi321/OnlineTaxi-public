package com.ruoxi.Service;

import com.google.common.base.Strings;
import com.ruoxi.ConstantResult;
import com.ruoxi.datatoobject.ResponseResult;
import com.ruoxi.request.LoginRequest;
import com.ruoxi.response.DigitalCodeResponse;
import com.ruoxi.response.VerifiedTokenResponse;
import com.ruoxi.serviceClient.PassengerUserClient;
import com.ruoxi.serviceClient.VerificationCodeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationService {
    @Autowired //自动注入依赖
    private VerificationCodeClient verificationCodeClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private PassengerUserClient passengerUserClient;

    private final String verificationCodeKeyPrefix = "verification-code:";
    public ResponseResult<DigitalCodeResponse> generateVerificationCode(String phoneNumber){
        ResponseResult<DigitalCodeResponse> digitalCodeResponseResponseResult = verificationCodeClient.getDigitalCode(6);
        int digitalCode = digitalCodeResponseResponseResult.getPayload().getDigitalCode();
        System.out.println("digitalCode = " + digitalCode);
        //save code to redis
        String verificationCodeKey = genCodeKey(phoneNumber);
        //return result
        stringRedisTemplate.opsForValue().set(verificationCodeKey,Integer.toString(digitalCode),2, TimeUnit.MINUTES);
        return ResponseResult.success();
    }
    public ResponseResult<VerifiedTokenResponse> verifyCode(String phoneNumber,String code){
        String verificationCodeKey = genCodeKey(phoneNumber);
        String verificationCodeInRedis = stringRedisTemplate.opsForValue().get(verificationCodeKey);
        if(Strings.isNullOrEmpty(verificationCodeInRedis)){
            return ResponseResult.fail(ConstantResult.VERIFICATION_ERROR.getCode(),ConstantResult.VERIFICATION_ERROR.getMessage());
        }
        if(!code.trim().equals(verificationCodeInRedis.trim())){
            return ResponseResult.fail(ConstantResult.VERIFICATION_ERROR.getCode(),ConstantResult.VERIFICATION_ERROR.getMessage());
        }
        // Check user information in Database
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPhoneNumber(phoneNumber);
        passengerUserClient.insertAsneed(loginRequest);
        // Generate token

        // return response
        VerifiedTokenResponse verifiedTokenResponse = new VerifiedTokenResponse();
        verifiedTokenResponse.setToken("token");
        return ResponseResult.success(verifiedTokenResponse);
    }
    private String genCodeKey(String Number){
        return verificationCodeKeyPrefix + Number;
    }

}
