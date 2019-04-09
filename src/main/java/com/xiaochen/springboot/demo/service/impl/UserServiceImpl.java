package com.xiaochen.springboot.demo.service.impl;

import com.xiaochen.springboot.demo.beans.User;
import com.xiaochen.springboot.demo.dao.UserDao;
import com.xiaochen.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 04-01 16:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User user(String username) {
        User user = userDao.getuser(username);
        return user;
    }
}
