package com.doug.hospitalmanager.controllers;

import com.doug.hospitalmanager.models.User;
import com.doug.hospitalmanager.routes.Routes;
import com.doug.hospitalmanager.services.UserService;
import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class UserController implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @FXML
    private MFXDatePicker birthDate;

    @FXML
    private MFXButton btnInsertUser;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField name;

    @FXML
    private MFXPasswordField password;

    @FXML
    private MFXCheckbox status;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void save(ActionEvent event) {
        var user = new User(null, name.getText(), birthDate.getCurrentDate(), email.getText(), password.getText(), status.isSelected());
        LOG.info(user.toString());

        userService.insert(user);

        Routes.INSERT_USER.getStage().close();
    }

}
