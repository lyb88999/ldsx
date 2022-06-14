package com.highcom.service.imp;

import com.highcom.mapper.UserMapper;
import com.highcom.po.User;
import com.highcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User showUser() {
        return userMapper.getUser();
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
