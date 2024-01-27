package com.ruoxi.Service;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

@Service
public class VerificationService {
    public String generateCode(String phoneNumber){
        String code = "123456";
        //TODO:Save code to redis with ttl
        //return result{
        //    "code":200,
        //    "message":"success"
        //}
        JSONObject returnJson = new JSONObject();
        returnJson.put("code",200);
        returnJson.put("message","success");
        return returnJson.toString();
    }

}
