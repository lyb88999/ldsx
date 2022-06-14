package com.highcom.dao;

import com.highcom.po.Emp;

import java.util.List;

public interface EmpDao {

    //查询所有员工
    public List<Emp> findAll();

    //删除员工信息
    public int deleteEmpByEmpno(Integer empno);
}
