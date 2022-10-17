package com.doug.hospitalmanager.routes;

import com.doug.hospitalmanager.controllers.HomeController;
import com.doug.hospitalmanager.controllers.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ControllerFactory {

    public static HomeController HOME;
    public static LoginController LOGIN;

    @Autowired
    public ControllerFactory(
            final HomeController HOME,
            final LoginController LOGIN
    ) {
        ControllerFactory.HOME = HOME;
        ControllerFactory.LOGIN = LOGIN;
    }
}
