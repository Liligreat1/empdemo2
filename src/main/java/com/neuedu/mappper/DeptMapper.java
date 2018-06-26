package com.neuedu.mappper;


import com.neuedu.entity.Dept;

import java.util.List;

public interface DeptMapper {
    //查询所有dept
    List<Dept> listDept();

    /**
     * 根据id数组删除部门
     * @param ids
     * @return影响行数
     */
    int deleteDeptById(int[] ids);
}
