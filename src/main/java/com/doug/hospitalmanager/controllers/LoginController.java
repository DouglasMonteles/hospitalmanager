package com.doug.hospitalmanager.controllers;

import com.doug.hospitalmanager.routes.Routes;
import com.doug.hospitalmanager.routes.StageFactory;
import com.doug.hospitalmanager.services.LoginService;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @FXML
    private MFXTextField login;

    @FXML
    private MFXPasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void login(ActionEvent event) {
        this.loginService.login(login.getText(), password.getText());
        LOG.info("login realizado com sucesso");
        StageFactory.showStageMaximized(Routes.HOME);
    }

}

