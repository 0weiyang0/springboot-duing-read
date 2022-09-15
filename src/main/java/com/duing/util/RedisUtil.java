package com.duing.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//将这个类交给spring来管理
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

//    设置key 和 value
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }
//通过key获取value
    public Object  get(String key){
        return redisTemplate.opsForValue().get(key);
    }

//   是否存在key
    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
//    key自增
    public void incr(String key){
        redisTemplate.opsForValue().increment(key);
    }


}
