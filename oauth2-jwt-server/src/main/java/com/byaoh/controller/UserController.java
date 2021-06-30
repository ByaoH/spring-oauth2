package com.byaoh.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author luliangyu
 * @date 2021-06-29 17:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public JSONObject get(Authentication authentication){
        JSONObject data = new JSONObject();
        data.put("code", 200);
        data.put("message", "操作成功");
        data.put("data", authentication.getPrincipal());
        return data;
    }
}
