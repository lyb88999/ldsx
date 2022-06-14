package com.highcom.dao.impl;

import com.highcom.dao.EmpDao;
import com.highcom.po.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {


    @Autowired
    private JdbcTemplate jt;
    @Override
    public List<Emp> findAll() {
        String sql = "select * from emp";
        return jt.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setHiredate(resultSet.getDate("hiredate"));
                emp.setDeptno(resultSet.getInt("deptno"));
                emp.setSal(resultSet.getDouble("sal"));
                emp.setComm(resultSet.getDouble("comm"));
                emp.setMgr(resultSet.getInt("mgr"));
                return emp;
            }
        });
    }

    @Override
    public int deleteEmpByEmpno(Integer empno) {
        String sql = "delete from emp where empno ="+empno;
        int ok = jt.update(sql);
        return ok;
    }
}
