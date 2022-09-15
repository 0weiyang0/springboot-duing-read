package com.duing.service.impl;
import com.duing.common.Commons;
import com.duing.service.RankService;
import com.duing.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void recordSearchCount(Long bookId) {
        String key = bookId + Commons.SEARCH_NUM;
        if (redisUtil.hasKey(key)){
            redisUtil.incr(key);
        }else {
            redisUtil.set(key,1);
        }
    }
}
