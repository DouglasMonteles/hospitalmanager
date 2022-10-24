package com.doug.hospitalmanager.services.impl;

import com.doug.hospitalmanager.models.User;
import com.doug.hospitalmanager.repositories.UserRepository;
import com.doug.hospitalmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }
}
