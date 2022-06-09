package test;

import com.highcom.mapper.EmpMapper;
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
    public void testFindAll() {
        List<Emp> emps = empMapper.findAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void testFindOne() {
        Emp emp = empMapper.findEmpByEmpno(7369);
        System.out.println(emp);
    }

    @Test
    public void testFindEmpByMul() {
        Emp emp = new Emp();
        emp.setJob("CLERK");
        emp.setDeptno(20);
        List<Emp> emps = empMapper.listEmp(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
    }

    @Test
    public void testFindEmpBySal() {
        List<Emp> emps = empMapper.listEmpBySal(3000.0);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
    }

    @Test
    public void testFindCountOfEmp() {
        int result = empMapper.ListEmpCount();
        System.out.println(result);
    }

    @Test
    public void testDeleteOne() {
        int ok = empMapper.deleteEmpByEmpno(7499);
        if (ok > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }


    @Test
    public void testAddOne1() {
        Emp emp = new Emp();
        emp.setEname("Steve Jobs");
        emp.setJob("CEO");
        emp.setHiredate(new Date());
        emp.setDeptno(10);
        int ok = empMapper.addEmp1(emp);
        if (ok > 0) {
            System.out.println("新增一条信息");
        }
    }

    @Test
    public void testAddOne2() {
        Emp emp = new Emp();
        emp.setEname("Tim Cook");
        emp.setJob("CLEVER");
        emp.setHiredate(new Date());
        emp.setDeptno(20);
        int ok = empMapper.addEmp2(emp);
        if (ok > 0) {
            System.out.println("新增一条信息");
            System.out.println("主键为" + emp.getEmpno());
        }
    }


    @Test
    public void updateOneEmp() {
        Emp emp = new Emp();
        emp.setEmpno(7698);
        emp.setJob("Director");
        emp.setSal(3600.0);
        int ok = empMapper.updateEmp(emp);
        if (ok > 0) {
            System.out.println("修改一条数据");
        }
    }


    @Test
    public void testDynamicByIfAndWhere() {
        Emp emp = new Emp();
        emp.setJob("CLERK");
        emp.setDeptno(20);
        List<Emp> emps = empMapper.DynamicByIfAndWhere(emp);
        for (Emp emp2 : emps) {
            System.out.println(emp2);
        }

    }


    @Test
    public void testDynamicByChoose() {
        Emp emp = new Emp();
        emp.setJob("CEO");
        emp.setDeptno(30);
        List<Emp> emps = empMapper.DynamicByChoose(emp);
        for (Emp emp2 : emps) {
            System.out.println(emp2);
        }
    }

    @Test
    public void testDynamicByTrim(){
        Emp emp = new Emp();
        emp.setEname("Trump");
        emp.setDeptno(40);
        emp.setJob("CODER");
        emp.setHiredate(new Date());
        int ok = empMapper.DynamicByTrim(emp);
        if(ok > 0){
            System.out.println("插入一条数据");
        }
    }


    @Test
    public void testDynamicBySet(){
        Emp emp = new Emp();
        emp.setEmpno(7920);
        emp.setJob("SAILOR");
        int ok = empMapper.DynamicBySet(emp);
        if(ok > 0){
            System.out.println("修改一条数据");
        }
    }


    @Test
    public void testDynamicByForEach(){
        int[] arr = {7918,7919,7920};
        int ok = empMapper.DynamicByForEach(arr);
        if(ok > 0){
            System.out.println("删除数据成功");
        }
    }


    @Test
    public void testMulToOne(){
        Emp emp = empMapper.getEmpById(7369);
        System.out.println(emp);
        System.out.println(emp.getDept());
        List<Emp> list = empMapper.listEmpAll();
        for(Emp e : list) {
            System.out.println(e);
            System.out.println(e.getDept());
        }
    }
}
