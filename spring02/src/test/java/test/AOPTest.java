package test;

import com.highcom.po.User;
import com.highcom.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AOPTest {
    public static void main(String[] args) {
        //读取Spring配置文件,获取Spring容器
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        //通过Spring容器的getBean方法获得对象
        UserService service = (UserService) context.getBean("userService");
        User user = service.showUser();
        user.setUsername("lyb");
        System.out.println(user);
    }
}
