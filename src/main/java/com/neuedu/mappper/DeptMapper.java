package com.neuedu.mappper;


import com.neuedu.entity.Dept;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 添加部门
     * @param dept
     * @return影响行数
     */
    int addDept(@Param("dept") Dept dept);

    /**
     * 查询dept表中的数据个数
     * @return
     */
    int getCount();

    /**
     * 通过id查询部门信息
     * @param id
     * @return部门信息
     */
    Dept getDeptById(int id);

    /**
     * 通过id修改部门信息
     * @param dept
     * @return影响行数
     */
    int updataDept(@Param("dept") Dept dept);

}
