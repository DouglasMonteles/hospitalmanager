package com.doug.hospitalmanager.controllers;

import com.doug.hospitalmanager.components.UserTableComponent;
import com.doug.hospitalmanager.models.User;
import com.doug.hospitalmanager.routes.Routes;
import com.doug.hospitalmanager.routes.StageFactory;
import com.doug.hospitalmanager.services.UserService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class HomeController implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @FXML
    private BorderPane borderPane;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void listUsers(ActionEvent event) throws IOException {
        var users = userService.findAll();
        var table = new UserTableComponent().build(users);

        borderPane.setCenter(table);
    }

    @FXML
    void insertUser(ActionEvent event) throws IOException {
        StageFactory.showIndependentStage(Routes.INSERT_USER);
    }

}