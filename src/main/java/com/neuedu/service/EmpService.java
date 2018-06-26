package com.neuedu.service;

import com.neuedu.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpService {

    /*
     * 查询所有emp
     * */
    List<Emp> listEmp();

    /**
     * 根据id查询emp
     * @param id
     * @return
     */
    Emp getEmpById(int id);

    /*
     * 根据数组来删除emp中的数据
     * */
    int deleteEmpByIds(int[] ids);

    /*
     *  添加emp
     */
    int saveEmp(Emp emp);
    int updateEmp(@Param("emp") Emp emp);

    /**
     * 根据部门id删除员工
     * @param
     * @return
     */
    int deleteEmpByDeptids(int[] dept_ids);
}
