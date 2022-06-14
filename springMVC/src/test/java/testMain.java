import com.highcom.dao.EmpDao;
import com.highcom.dao.UserDao;
import com.highcom.po.Emp;
import com.highcom.po.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class testMain {

    @Autowired
    private BasicDataSource basicDataSource;


    @Autowired
    private UserDao userDao;

    @Autowired
    private EmpDao empDao;

    @Test
    public void testConnection(){
        try{
            System.out.println(basicDataSource.getConnection());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //测试登陆
    @Test
    public void testLogin(){
        User user = userDao.userLogin("lisi","666666");
        System.out.println(user);
    }


    //测试查询员工信息
    @Test
    public void testQuery(){
        List<Emp> empList = empDao.findAll();
        for(Emp emp : empList){
            System.out.println(emp);
        }
    }
}
