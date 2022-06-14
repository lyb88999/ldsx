package com.highcom.dao;

import com.highcom.po.User;

public interface UserDao {

    //登陆功能
    public User userLogin(String username, String passwork);

}
