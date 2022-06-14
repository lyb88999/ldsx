package com.highcom.mapper.impl;

import com.highcom.mapper.UserMapper;
import com.highcom.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    private User user;

    @Override
    public User getUser() {
        user.setUsername("张三");
        return user;
    }
}
