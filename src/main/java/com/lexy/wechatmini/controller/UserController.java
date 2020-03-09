package com.lexy.wechatmini.controller;

import com.alibaba.fastjson.JSONObject;
import com.lexy.wechatmini.entities.User;
import com.lexy.wechatmini.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mini")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/aa")
    public String aa(){
        return "aa";
    }

    @RequestMapping("/addUser")
    public Boolean addUser(User user){
        System.out.println(user);

        return userService.addUser(user);
    }

    @RequestMapping("/checkUser")
    public String checkUser(String openid){
        System.out.println("openid = " + openid);
        User user = userService.getUserByOpenid(openid);
        JSONObject result = new JSONObject();
        if (null != user) {
            result.put("result",true);
            result.put("user",JSONObject.toJSONString(user));
        }else {
            result.put("result",false);
        }
        System.out.println(result.toJSONString());
        return result.toJSONString();
    }
}
