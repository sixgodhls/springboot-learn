package com.example.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public final class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean expire(String key ,long timeout){
        if (timeout > 0) {
        redisTemplate.expire(key,timeout, TimeUnit.SECONDS);
        return true;
        }
        else {
            return false;
        }
    }

    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public boolean remove(String key){
        if(redisTemplate.hasKey(key)){
            return redisTemplate.delete(key);
        }else {
            return false;
        }
    }

    public void remove(String... keys){
        for(String key:keys){
            remove(key);
        }
    }
}

