package com.neuedu.mappper;


import com.neuedu.entity.User;


public interface UserMapper {

    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

}
