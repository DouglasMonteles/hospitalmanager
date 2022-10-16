package com.doug.hospitalmanager.routes;

import javafx.stage.Stage;

import java.io.IOException;

public abstract class StageFactory {

    private static Stage STAGE;

    public static void showStage(Routes route)  {
        STAGE.setTitle(route.getTitle());
        try {
            STAGE.setScene(route.getScene());
            STAGE.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showStageMaximized(Routes route)  {
        STAGE.setMaximized(true);
        showStage(route);
    }

    public static void setGlobalStage(Stage stage) {
        StageFactory.STAGE = stage;
    }

}
