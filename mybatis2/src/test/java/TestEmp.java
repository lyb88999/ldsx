import com.highcom.mapper.EmpMapper;
import com.highcom.po.Dept;
import com.highcom.po.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestEmp {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private EmpMapper empMapper;


    @Before
    public void before() throws IOException {
        //读取全局配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //拿到SqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //拿到SqlSession
        sqlSession = factory.openSession();
        //获取接口实现类对象
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }


    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }


    @Test
    public void testMulToOne(){
        Emp emp = empMapper.getEmpById(7369);
        System.out.println(emp);
        System.out.println(emp.getDept());
        List<Emp> list = empMapper.listEmpAll();
        for(Emp e : list) {
            System.out.println(e);
            Dept dept = e.getDept();
            if(dept != null)
                System.out.println("\t\t"+dept.getDeptno()+","+dept.getDname()+","+dept.getLoc());
        }
    }
}
