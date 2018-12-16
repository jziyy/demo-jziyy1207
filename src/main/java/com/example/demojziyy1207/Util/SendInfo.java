package com.example.demojziyy1207.Util;


public class SendInfo {
    public static void sendInfo(String json){
        String requestUrl = "http://172.22.0.200:9200/gateway/api_gateway_statistics/_bulk";

        String result =DemoHttpUtil.doPost(requestUrl,json);
        System.out.println(result);

    }
    public static String sendVerifyInfo(String json){
        String requestUrl = "http://172.22.0.200:9200/gateway/api_gateway_statistics/_mget";

        String result =DemoHttpUtil.doPost(requestUrl,json);
        return result;
    }
}
