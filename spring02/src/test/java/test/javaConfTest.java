package test;

import com.highcom.po.User;
import com.highcom.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class javaConfTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService)context.getBean("userService");
        User user = service.showUser();
        System.out.println(user);
    }
}
