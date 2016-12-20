package com.wsjonly.practice;

import com.wsjonly.util.HttpUtil;

public class HttpUtilTest {
    public static void main(String[] args) {

        String response = HttpUtil.get("http://release.mtmq.test.sankuai.info/subscribe/list?subscribeName=&consumerAppkeyName=waimai&currentPage=", null);
        System.out.println(response);
    }
}
