package com.lexy.wechatmini.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public SecurityUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //获取校验用密码
    @Override
    public String getPassword() {
        return this.password;
    }

    //获取校验用户名
    @Override
    public String getUsername() {
        return this.username;
    }

    //账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //帐户密码是否未过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //账户是否可用
    @Override
    public boolean isEnabled() {
        return false;
    }
}
