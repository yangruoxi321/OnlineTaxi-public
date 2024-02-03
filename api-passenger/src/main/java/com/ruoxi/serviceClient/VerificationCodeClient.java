package com.ruoxi.serviceClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ruoxi.datatoobject.ResponseResult;
import com.ruoxi.response.DigitalCodeResponse;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("verification-code")
public interface  VerificationCodeClient {
    @RequestMapping(method = RequestMethod.GET,value = "/digitalCode")
    ResponseResult<DigitalCodeResponse> getDigitalCode(@RequestParam("size") int size);
}

