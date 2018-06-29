package com.neuedu.service.impl;

import com.neuedu.entity.Dept;
import com.neuedu.mappper.DeptMapper;
import com.neuedu.mappper.EmpMapper;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> listDept() {
        return deptMapper.listDept();
    }

    @Override
    public int getCount() {
        return deptMapper.getCount();
    }

    @Override
    public int deleteDeptById(int[] ids) {
        int count = deptMapper.deleteDeptById(ids);
        empMapper.deleteEmpByDeptids(ids);
        return count;
    }

    @Override
    public int addDept(Dept dept) {
        deptMapper.addDept(dept);
        int pageNum = deptMapper.getCount() / 10;
        return deptMapper.getCount() % 10 == 0?pageNum : pageNum + 1;
    }

    @Override
    public Dept getDeptById(int id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public int updataDept(Dept dept) {
        return deptMapper.updataDept(dept);
    }
}
