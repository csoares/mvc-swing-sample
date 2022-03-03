package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.entity.User;
import com.example.accessingdatamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserWithId(Integer id) {
       return userRepository.findById(id).get();
    }


}
