package com.neuedu.mappper;


import com.neuedu.entity.Dept;

import java.util.List;

public interface DeptMapper {
    //查询所有dept
    List<Dept> listDept();
}