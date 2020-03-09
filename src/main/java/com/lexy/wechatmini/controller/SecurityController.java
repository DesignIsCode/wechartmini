package com.lexy.wechatmini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sec")
public class SecurityController {

    @RequestMapping("/main")
    public String  main() {
        return "main";
    }


}
