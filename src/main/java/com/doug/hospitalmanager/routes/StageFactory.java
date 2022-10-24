package com.doug.hospitalmanager.routes;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public abstract class StageFactory {

    private static Stage STAGE;

    public static void showStageMaximized(Routes route) {
        buildStage(route);
        STAGE.setResizable(true);
        STAGE.setMaximized(true);
        show(StageFactory.STAGE);
    }

    public static void showStageNotResizable(Routes route)  {
        buildStage(route);
        STAGE.setResizable(false);
        show(StageFactory.STAGE);
    }

    public static void showIndependentStage(Routes route) {
        var stage = buildIndependentStage(route);

        stage.setResizable(false);

        show(stage);
        route.setStage(stage);
    }

    private static void buildStage(Routes route)  {
        if (STAGE != null) {
            STAGE.close();
        }

        STAGE = new Stage();
        STAGE.setTitle(route.getTitle());

        try {
            STAGE.setScene(route.buildScene());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage buildIndependentStage(Routes route) {
        var stage = new Stage();

        stage.setTitle(route.getTitle());

        try {
            stage.setScene(route.buildScene());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stage;
    }

    private static void show(Stage stage) {
        stage.show();
    }

}
