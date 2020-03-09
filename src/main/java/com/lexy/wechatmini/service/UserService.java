package com.lexy.wechatmini.service;

import com.lexy.wechatmini.entities.User;

public interface UserService {

    User getUserByOpenid(String openid);

    boolean addUser(User user);
}
