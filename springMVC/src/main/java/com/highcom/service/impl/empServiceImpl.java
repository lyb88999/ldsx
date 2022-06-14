package com.highcom.service.impl;

import com.highcom.dao.EmpDao;
import com.highcom.dao.UserDao;
import com.highcom.dao.impl.EmpDaoImpl;
import com.highcom.po.Emp;
import com.highcom.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class empServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> findAll() {

        return empDao.findAll();
    }

    @Override
    public int deleteEmpByEmpno(Integer empno) {
        return empDao.deleteEmpByEmpno(empno);
    }
}
