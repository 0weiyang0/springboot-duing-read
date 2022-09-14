package com.duing.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectionUtil {
    public  static String  qidianStr = "https://read.qidian.com/chapter/EVyNRTiDDgtwKI0S3HHgow2/UIdySaVc-Uy2uJcMpdsVgA2/";

    public static void main(String[] args) {
        String result = doGet(qidianStr);
        System.out.println();
    }
    public static String doGet(String qidianStr) {
        HttpURLConnection  connection = null;
        StringBuilder result = new StringBuilder();
        InputStream in = null;
        BufferedReader br = null;
        try {
            //创建URL
            URL url = new URL(qidianStr);
            //打开连接
           connection =(HttpURLConnection) url.openConnection();
           //设置连接的请求方式
           connection.setRequestMethod("GET");
           //连接超时时间
           connection.setConnectTimeout(15000);
           //读取超时时间     客户端和服务端先建立连接，连接成功后读取数据，数据读取完
            //                响应成功
            //连接时间受客户端的带宽，客户端和服务端的距离 服务端自身的响应速度等因素的影响
            //读取时间主要受服务端返回数据的大小所影响
           connection.setReadTimeout(60000);
           //设置请求头的信息
            connection.setRequestProperty("Accept","application/json");
            //发送请求
            connection.connect();
            if (connection.getResponseCode() == 200){
              in =  connection.getInputStream();
              br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
              String line;
              while ((line = br.readLine()) != null){
                  result.append(line);
                  // System.out.println(line);
              }
            }else {
                System.out.println("ResponseCode is not 200,is"+connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (in != null){
                    in.close();
                }
                connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return result.toString();
    }
}
