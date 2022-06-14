package com.highcom.service.impl;

import com.highcom.mapper.UserMapper;
import com.highcom.po.User;
import com.highcom.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User showUser() {
        return userMapper.getUser();
    }
}
