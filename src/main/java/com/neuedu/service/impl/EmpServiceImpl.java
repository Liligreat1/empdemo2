package com.neuedu.service.impl;

import com.neuedu.entity.Emp;
import com.neuedu.mappper.EmpMapper;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> listEmp() {
        return empMapper.listEmp();
    }

    @Override
    public Emp getEmpById(int id) {
        return empMapper.getEmpById(id);
    }


    @Override
    public int deleteEmpByIds(int[] ids) {
        return empMapper.deleteEmpByIds(ids);
    }

    @Override
    public int saveEmp(Emp emp) {
        empMapper.saveEmp(emp);
        int pageNum = empMapper.getCount() / 10;
        return empMapper.getCount() % 10 == 0 ? pageNum : pageNum + 1;
    }

    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }
}
