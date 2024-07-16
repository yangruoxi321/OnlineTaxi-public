package com.ruoxi.serviceClient;

import com.ruoxi.datatoobject.ResponseResult;
import com.ruoxi.request.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient
public interface PassengerUserClient {
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult insertAsneed(LoginRequest loginRequest);
}
