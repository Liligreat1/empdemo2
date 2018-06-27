package com.neuedu.service;


import com.neuedu.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 添加user的方法
     * @param user
     * @return影响行数
     */
    int saveUser(@Param("user") User user);
}
