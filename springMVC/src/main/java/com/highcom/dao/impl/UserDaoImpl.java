package com.highcom.dao.impl;

import com.highcom.dao.UserDao;
import com.highcom.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public User userLogin(String username, String passwork) {
        System.out.println("----login----");
        User user = null;
        String sql = "select * from user where username=? and password=?";
        Object[] arr = {username, passwork};
        List<User> users = jt.query(sql,arr, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        if (users.size() > 0) {
            user = users.get(0);
        }
        return user;
    }
}
