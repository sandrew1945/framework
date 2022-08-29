package com.sandrew.bootsec.core.nosql;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by summer on 2018/2/21.
 */
@Component
@Log4j2
public class RedisUtil
{
    @Resource RedisUtilPro redisUtilPro;


    /**
     * @Description: 批量删除缓存
     * @Author: hj
     * @Date: 17:13 2017/10/24
     */
    public void remove(final String... keys)
    {
        for (String key : keys)
        {
            remove(key);
        }
    }

    /**
     * @Description: 批量删除缓存(通配符)
     * @Author: hj
     * @Date: 16:52 2017/10/24
     */
    public void removePattern(final String pattern)
    {
        Set<Serializable> keys = redisUtilPro.redisTemplate("es").keys(pattern);
        if (keys.size() > 0)
        {
            redisUtilPro.redisTemplate("es").delete(keys);
        }
    }

    /**
     * @Description: 删除缓存
     * @Author: hj
     * @Date: 16:51 2017/10/24
     */
    public void remove(final String key)
    {
        if (exists(key))
        {
            redisUtilPro.redisTemplate("es").delete(key);
        }
    }

    /**
     * @Description: 判断缓存中是否有对应的value
     * @Author: hj
     * @Date: 16:50 2017/10/24
     */
    public boolean exists(final String key)
    {
        return redisUtilPro.redisTemplate("es").hasKey(key);
    }

    /**
     * @Description: 读取缓存
     * @Author: hj
     * @Date: 16:49 2017/10/24
     */
    public Object get(final String key)
    {
        return redisUtilPro.redisTemplate("es").opsForValue().get(key);
    }

    /**
     * @Description: 写入缓存
     * @Author: hj
     * @Date: 16:48 2017/10/24
     */
    public boolean set(final String key, Object value)
    {
        boolean result = false;
        try
        {
            redisUtilPro.redisTemplate("es").opsForValue().set(key, value);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Description: 写入缓存(可以配置过期时间)
     * @Author: hj
     * @Date: 16:46 2017/10/24
     */
    public boolean set(final String key, Object value, Long expireTime)
    {
        boolean result = false;
        try
        {
            redisUtilPro.redisTemplate("es").opsForValue().set(key, value);
            redisUtilPro.redisTemplate("es").expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
