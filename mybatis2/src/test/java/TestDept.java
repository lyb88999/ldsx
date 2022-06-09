import com.highcom.mapper.DeptMapper;
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
import java.util.List;
public class TestDept {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private DeptMapper deptMapper;

    @Before
    public void before() throws IOException {
        //读取全局配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //拿到SqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //拿到SqlSession
        sqlSession = factory.openSession();
        //获取接口实现类对象
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }


    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void findDept(){
        List<Dept> depts = deptMapper.findDepts();
        for(Dept dept:depts){
            System.out.println(dept.getDeptno()+","+dept.getDname()+","+dept.getLoc());
            List<Emp> emps = dept.getEmpList();
            for (Emp emp : emps) {
                System.out.println("\t\t"+emp.getEmpno()+","+emp.getEname()+","+emp.getSal());
            }
        }
    }
}
