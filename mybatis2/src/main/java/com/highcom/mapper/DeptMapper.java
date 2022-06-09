package com.highcom.mapper;

import com.highcom.po.Dept;

import java.util.List;

public interface DeptMapper {

    // 查询每个部门员工信息
    public List<Dept> findDepts();
}
