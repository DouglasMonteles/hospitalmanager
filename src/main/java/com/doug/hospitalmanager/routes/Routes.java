package com.doug.hospitalmanager.routes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public enum Routes {

    HOME (620, 540) {
        private Stage stage;

        @Override
        public Stage getStage() {
            return stage;
        }

        @Override
        public void setStage(Stage stage) {
            this.stage = stage;
        }

        @Override
        public String getTitle() {
            return "Home";
        }

        @Override
        public FXMLLoader getResource() {
            return new FXMLLoader(Routes.class.getResource("/fxml/home-view.fxml"));
        }

        @Override
        public Scene buildScene() throws IOException {
            var fxmlLoader = getResource();
            fxmlLoader.setControllerFactory(param -> ControllerFactory.HOME);
            return new Scene(fxmlLoader.load(), HOME.width, HOME.height);
        }
    },

    LOGIN (720, 420) {
        private Stage stage;

        @Override
        public Stage getStage() {
            return stage;
        }

        @Override
        public void setStage(Stage stage) {
            this.stage = stage;
        }

        @Override
        public String getTitle() {
            return "Login";
        }

        @Override
        public FXMLLoader getResource() {
            return new FXMLLoader(Routes.class.getResource("/fxml/login-view.fxml"));
        }

        @Override
        public Scene buildScene() throws IOException {
            var fxmlLoader = getResource();
            fxmlLoader.setControllerFactory(param -> ControllerFactory.LOGIN);
            return new Scene(fxmlLoader.load(), LOGIN.width, LOGIN.height);
        }
    },

    INSERT_USER (720, 420) {
        private Stage stage;

        @Override
        public Stage getStage() {
            return stage;
        }

        @Override
        public void setStage(Stage stage) {
            this.stage = stage;
        }

        @Override
        public String getTitle() {
            return "Cadastro de Usuário";
        }

        @Override
        public FXMLLoader getResource() {
            return new FXMLLoader(Routes.class.getResource("/fxml/forms/user-registration.fxml"));
        }

        @Override
        public Scene buildScene() throws IOException {
            var fxmlLoader = getResource();
            fxmlLoader.setControllerFactory(param -> ControllerFactory.USER);
            return new Scene(fxmlLoader.load(), INSERT_USER.width, INSERT_USER.height);
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

    public abstract Scene buildScene() throws IOException;

    public abstract Stage getStage();

    public abstract void setStage(Stage stage);

}
