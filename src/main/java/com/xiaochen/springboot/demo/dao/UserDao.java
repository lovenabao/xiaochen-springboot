package com.xiaochen.springboot.demo.dao;

import com.xiaochen.springboot.demo.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author shkstart
 * @create 04-01 16:32
 */
@Mapper
public interface UserDao {
    @Select("select * from user where username =#{username}")
    public User getuser(String username);
}
