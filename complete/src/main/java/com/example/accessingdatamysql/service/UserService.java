package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.entity.User;

import java.util.List;


public interface UserService {
    // save operation
    User saveUser(User user);
    List<User> fetchUserList();
   User getUserWithId(Integer id);

}
