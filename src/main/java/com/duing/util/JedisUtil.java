package com.duing.util;


import redis.clients.jedis.Jedis;

public class JedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.101",6379);
        jedis.set("jedis","hello jedis");
        System.out.println(jedis.get("jedis"));
        jedis.close();
    }
}
