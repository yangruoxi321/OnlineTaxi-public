package com.ruoxi.passengeruser.service;

import com.ruoxi.datatoobject.ResponseResult;
import com.ruoxi.passengeruser.constants.Status;
import com.ruoxi.passengeruser.entity.User;
import com.ruoxi.passengeruser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ResponseResult loginAndCreateUserWhenNeed(String phoneNumber){
        System.out.println("phoneNumber = " + phoneNumber);
        // Search user based on the phone number in Mysql.
        Map<String, Object> phoneMap = new HashMap();
        phoneMap.put("phone_number", phoneNumber);
        List<User> users = userMapper.selectByMap(phoneMap);
        // Check if the user exists.
        if (users.isEmpty()) {
        // Insert user if the user doesn't exist.

            User newUser = new User();
            newUser.setPhoneNumber(phoneNumber);
            newUser.setName("random name" +
                    UUID.randomUUID().toString().substring(0,5));
            newUser.setStatus(Status.ACTIVE);
            userMapper.insert(newUser);
        }
        return ResponseResult.success();
    }
}