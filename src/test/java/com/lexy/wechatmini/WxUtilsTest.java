package com.lexy.wechatmini;

import com.lexy.wechatmini.utils.WxUtils;

public class WxUtilsTest {

    public static void main(String[] args) {
        String sessionkey = "P+8rj+SodiJJCT/d2SWg4g==";
        String iv = "M8Ry4hzrvwdQzB58CyRuVw==";
        String baseUnion = "ZPx09PFW3kVAZRgIO3QD40s/4kiMyymbNXHYlFBT4Iv+cyhBUxiXAoFgVAUNZ/jsk/SlsTO/I26uowI9SCbGrlcQbwKxDNJZsJf58iQWANZgx5hWSB+dtQfOqcsTtahfiqiGZKJ33sM+q95r8MpeofZLJwd0ZKqqSG+JBb4NDFOVQAziGUikMJxlNwBbKSouPbihM/TkWcMRsdZnVQR07h7/kwFpCIp0cvhqIt2HfCGc6jfD/pEMW98pKgDyr4WyfeE0IXNQ/zVaGX1t6sehApl5b/POhSSBIwa4AnYtL3yqQX4iEu1axeMRmKxyeR/IhK9JGqYP4tHjHGlCwTO+qmaCKgCLIN7or19BiKC49+dUiqQKk2CRSoR8U7NaxhsMAmzQLLL2qS9heLhsk2d37L7qO5ErK6pZYCh9Mo+USPHhuD6nH+usZJn5YKfEnojMzRM5BY17MJB23xK0dumlquJd7TRJbnOA/4ztp8wBhJx87GYAkdEYbGBUbnwequeo";

        WxUtils wxUtils = new WxUtils();
        String res = wxUtils.decryptData(baseUnion,sessionkey,iv);
        System.out.println(res);
    }

}
