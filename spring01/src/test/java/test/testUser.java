package test;

import com.highcom.mapper.UserMapper;
import com.highcom.mapper.impl.UserMapperImpl;
import com.highcom.po.User;
import com.highcom.service.UserService;
import com.highcom.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class testUser {
    public static void main(String[] args) {
        //从容器中取得想创建的对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService us = (UserService)applicationContext.getBean("userService");
        User user = us.showUser();
        System.out.println(user.getUsername()+user.getAddress());

    }
}
