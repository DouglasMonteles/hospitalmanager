package com.doug.hospitalmanager.services.impl;

import com.doug.hospitalmanager.exceptions.UserNotFoundException;
import com.doug.hospitalmanager.repositories.UserRepository;
import com.doug.hospitalmanager.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    public void login(String email, String password) {
        var user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException(String.format("Usuário %s não encontrado!", email));
        }

        if (!user.isActive()) {
            throw new UserNotFoundException("Este usuário está inativo!");
        }

        if (!user.getPassword().equals(password)) {
            throw new UserNotFoundException("Nenhum usuário com a senha informada foi encontrado!");
        }
    }

}
