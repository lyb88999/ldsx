package test;

import com.highcom.po.User;
import com.highcom.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {
    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        user.setUsername("李四");
        System.out.println(user.getUsername());
    }

    @Test
    public  void test2(){
        User user = userService.showUser();
        System.out.println(user.getUsername());
    }
}
