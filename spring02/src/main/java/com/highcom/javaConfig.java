package com.highcom;


import com.highcom.mapper.UserMapper;
import com.highcom.mapper.impl.UserMapperImpl;
import com.highcom.service.UserService;
import com.highcom.service.imp.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javaConfig {
    @Bean
    public UserMapper userMapper(){
        return new UserMapperImpl();
    }

    @Bean
    public UserService userService(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper());
        return userService;
    }
}
