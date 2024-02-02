package com.ruoxi.verificationcode.Controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DigitalCodeController {
    @GetMapping("/digitalCode")
    public String digitalCode(@RequestParam("size") int size){
        System.out.println("size = " + size);
        JSONObject result = new JSONObject();
        result.put("code","201");
        result.put("message","success");
        JSONObject payload = new JSONObject();
        payload.put("digitalCode","123456");
        result.put("payload",payload);
        return result.toString();
    }
}
