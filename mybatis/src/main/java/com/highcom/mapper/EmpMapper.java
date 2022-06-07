package com.highcom.mapper;

import com.highcom.po.Emp;

import java.util.List;

public interface EmpMapper {

    //查询所有记录
    public List<Emp> findAll();

    //查询一条记录
    public Emp findEmpByEmpno(Integer empno);

    //多条件查询
    public List<Emp> listEmp(Emp emp);

    //按工资查询
    public List<Emp> listEmpBySal(Double sal);

    //查询人数
    public int ListEmpCount();

    //删除一条记录
    public int deleteEmpByEmpno(Integer empno);

    //增加一条记录(不获取主键)
    public int addEmp1(Emp emp);

    //增加一条记录(获取主键)
    public int addEmp2(Emp emp);

    //修改一条记录
    public int updateEmp(Emp emp);

    //动态sql(if where)
    public List<Emp> DynamicByIfAndWhere(Emp emp);

    //动态sql(choose)
    public List<Emp> DynamicByChoose(Emp emp);

    //动态sql(trim)
    public int DynamicByTrim(Emp emp);

    //动态sql(set)
    public int DynamicBySet(Emp emp);

    //动态sql(forEach)
    public int DynamicByForEach(int[] a);


}
