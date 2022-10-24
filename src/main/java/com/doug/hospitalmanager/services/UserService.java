package com.doug.hospitalmanager.services;

import com.doug.hospitalmanager.models.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    void insert(User user);
}
