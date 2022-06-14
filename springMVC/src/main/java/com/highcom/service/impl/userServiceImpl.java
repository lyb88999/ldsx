package com.highcom.service.impl;

import com.highcom.dao.UserDao;
import com.highcom.po.User;
import com.highcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.userLogin(user.getUsername(), user.getPassword());
    }
}
