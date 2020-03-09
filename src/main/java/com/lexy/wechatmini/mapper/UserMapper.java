package com.lexy.wechatmini.mapper;

import com.lexy.wechatmini.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByOpenid(@Param("openid")String openid);

    boolean addUser(User user);
}
