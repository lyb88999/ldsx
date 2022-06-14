package test;

import com.highcom.po.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testStu {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student stu1 = (Student) applicationContext.getBean("stu1");
        Student stu3 = (Student) applicationContext.getBean("stu3");
        System.out.println(stu1.toString());
        System.out.println(stu3.getHobbies());
    }
}
