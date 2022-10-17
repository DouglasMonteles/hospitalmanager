package com.doug.hospitalmanager.routes;

import com.doug.hospitalmanager.controllers.HomeController;
import com.doug.hospitalmanager.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public enum Routes {

    HOME (620, 540) {
        @Autowired
        private HomeController homeController;

        @Override
        public String getTitle() {
            return "Home";
        }

        @Override
        public FXMLLoader getResource() {
            return new FXMLLoader(Routes.class.getResource("/fxml/home-view.fxml"));
        }

        @Override
        public Scene getScene() throws IOException {
            var fxmlLoader = getResource();
            fxmlLoader.setControllerFactory(param -> ControllerFactory.HOME);
            return new Scene(fxmlLoader.load(), HOME.width, HOME.height);
        }
    },

    LOGIN (620, 420) {
        @Override
        public String getTitle() {
            return "Login";
        }

        @Override
        public FXMLLoader getResource() {
            return new FXMLLoader(Routes.class.getResource("/fxml/login-view.fxml"));
        }

        @Override
        public Scene getScene() throws IOException {
            var fxmlLoader = getResource();
            fxmlLoader.setControllerFactory(param -> ControllerFactory.LOGIN);
            return new Scene(fxmlLoader.load(), LOGIN.width, LOGIN.height);
        }
    };

    private double width;
    private double height;

    Routes () {}

    Routes(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public abstract String getTitle();

    public abstract FXMLLoader getResource();

    public abstract Scene getScene() throws IOException;

}
