package com.duing.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtil {
    private static String urlStr = "https://read.qidian.com/chapter/EVyNRTiDDgtwKI0S3HHgow2/UIdySaVc-Uy2uJcMpdsVgA2/";


     public static String doGet(String urlStr) {
         String  result = null;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse httpResponse = null;
    //创建client对象
    httpClient = HttpClients.createDefault();
    //
    HttpGet httpGet = new HttpGet(urlStr);
    //设置请求头
    httpGet.addHeader("Accept", "application/json");

    RequestConfig config = RequestConfig.custom().
            setConnectTimeout(15000).
            setSocketTimeout(60000).
            setConnectionRequestTimeout(35000).
            build();
    //将连接进行复用   连接池
    //setConnectionRequestTimeout  从连接池获取连接的超时时间
    httpGet.setConfig(config);
    //执行请求
    try {
        httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        result = EntityUtils.toString(entity);
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        try {
            if (httpResponse != null){
                httpResponse.close();
            }
            if (httpClient != null){
                httpClient.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    return result;
}

    public static void main(String[] args) {
       String result =  doGet(urlStr);
        System.out.println(result);
    }

}

