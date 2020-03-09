package com.lexy.wechatmini.entities;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User implements Serializable {
    private Integer id;
    private String username;
    private String phonenumber;
    private String idcard;
    private String openid;
    private String unionid;
    private String remark;

}
