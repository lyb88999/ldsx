package com.highcom.service;

import com.highcom.po.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> findAll();

    public int deleteEmpByEmpno(Integer empno);
}
