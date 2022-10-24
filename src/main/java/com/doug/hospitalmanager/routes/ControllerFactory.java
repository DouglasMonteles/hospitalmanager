package com.doug.hospitalmanager.routes;

import com.doug.hospitalmanager.controllers.HomeController;
import com.doug.hospitalmanager.controllers.LoginController;
import com.doug.hospitalmanager.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ControllerFactory {

    public static HomeController HOME;
    public static LoginController LOGIN;
    public static UserController USER;

    @Autowired
    public ControllerFactory(
            final HomeController HOME,
            final LoginController LOGIN,
            final UserController USER
    ) {
        ControllerFactory.HOME = HOME;
        ControllerFactory.LOGIN = LOGIN;
        ControllerFactory.USER = USER;
    }
}
