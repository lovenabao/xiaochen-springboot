package com.xiaochen.springboot.demo.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;

/**
 * @author shkstart
 * @create 04-02 14:29
 */
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {


}
