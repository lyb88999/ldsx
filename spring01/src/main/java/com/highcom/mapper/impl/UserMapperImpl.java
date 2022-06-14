package com.highcom.mapper.impl;

import com.highcom.mapper.UserMapper;
import com.highcom.po.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public User getUser() {
        return new User("123","harbin");
    }
}
