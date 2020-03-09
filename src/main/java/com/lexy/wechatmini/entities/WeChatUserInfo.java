package com.lexy.wechatmini.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class WeChatUserInfo implements Serializable {

    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;
}
