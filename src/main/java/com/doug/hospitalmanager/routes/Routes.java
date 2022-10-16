package com.doug.hospitalmanager.routes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public enum Routes {

    HOME (620, 540) {
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
            return new Scene(fxmlLoader.load(), HOME.width, HOME.height);
        }
    };

    private double width;
    private double height;

    Routes() {}

    Routes(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public abstract String getTitle();

    public abstract FXMLLoader getResource();

    public abstract Scene getScene() throws IOException;

}
