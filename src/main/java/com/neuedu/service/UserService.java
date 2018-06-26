package com.neuedu.service;


import com.neuedu.entity.User;

public interface UserService {

    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
