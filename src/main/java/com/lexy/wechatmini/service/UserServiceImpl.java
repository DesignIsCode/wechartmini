package com.lexy.wechatmini.service;

import com.lexy.wechatmini.entities.User;
import com.lexy.wechatmini.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByOpenid(String openid) {
        return userMapper.getUserByOpenid(openid);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }
}
