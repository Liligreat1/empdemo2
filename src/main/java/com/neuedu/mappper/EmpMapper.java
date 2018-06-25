package com.neuedu.mappper;

import com.neuedu.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /*
    * 查询所有emp
    * */
    List<Emp> listEmp();

    /**
     * 查询现有的数据个数
     * @return
     */
    int getCount();

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
    int saveEmp(@Param("emp") Emp emp);

    /**
     * 修改emp中的信息
     * @param emp
     * @return
     */
    int updateEmp(@Param("emp") Emp emp);
}
