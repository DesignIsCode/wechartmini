package com.lexy.wechatmini.controller;

import com.alibaba.fastjson.JSONObject;
import com.lexy.wechatmini.entities.WeChatUserInfo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/mini")
public class WeChatLoginController {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @GetMapping("/initUserInfo")
    private String login(@RequestParam("code") String code) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appsecret+"&js_code="+code+"&grant_type=authorization_code";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        System.out.println(jsonObject);
        WeChatUserInfo userInfo = new WeChatUserInfo();
        userInfo.setSession_key((String) jsonObject.get("session_key"));
        userInfo.setOpenid((String) jsonObject.get("openid"));
        userInfo.setUnionid((String) jsonObject.get("unionid"));
        userInfo.setErrcode((Integer) jsonObject.get("errcode"));
        userInfo.setErrmsg((String) jsonObject.get("errmsg"));
        return JSONObject.toJSONString(userInfo);
    }

}
