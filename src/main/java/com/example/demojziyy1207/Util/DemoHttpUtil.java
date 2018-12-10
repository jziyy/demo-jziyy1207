package com.example.demojziyy1207.Util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DemoHttpUtil {
   public static String doPost(String httpUrl,String param){
       HttpURLConnection connection = null;
       InputStream inputStream = null;
       OutputStream outputStream =null;
       BufferedReader bufferedReader =null;
       String result =null;
       try {
           URL url = new URL(httpUrl);
           connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("POST");
           // 设置通用的请求属性
           connection.setRequestProperty("Connection", "Keep-Alive");
           connection.setUseCaches(false);
           connection.setDoOutput(true);
           connection.setDoInput(true);

           connection.setRequestProperty("Content-Type","application/json");
         //  connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
           connection.connect();

           outputStream = connection.getOutputStream();
           //outputStream
           outputStream.write(param.getBytes("UTF-8"));
           String temp =null;
           StringBuilder stringBuilder =new StringBuilder();
               inputStream =connection.getInputStream();
               bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
               while ((temp=bufferedReader.readLine())!=null){
                   stringBuilder.append(temp);
               }
               result = stringBuilder.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           if (null != bufferedReader){
               try {
                   bufferedReader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null!=outputStream){
               try {
                   outputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (null !=inputStream){
               try {
                   inputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       connection.disconnect();


       return result;
   }
}
