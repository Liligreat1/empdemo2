package com.neuedu.service.impl;

import com.neuedu.entity.Dept;
import com.neuedu.entity.User;
import com.neuedu.mappper.DeptMapper;
import com.neuedu.mappper.UserMapper;
import com.neuedu.service.DeptService;
import com.neuedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
