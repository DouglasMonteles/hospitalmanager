package com.doug.hospitalmanager.routes;

import javafx.stage.Stage;

import java.io.IOException;

public abstract class StageFactory {

    private static Stage STAGE;

    public static void showStageMaximized(Routes route) {
        buildStage(route);
        STAGE.setResizable(true);
        STAGE.setMaximized(true);
        show();
    }

    public static void showStageNotResizable(Routes route)  {
        buildStage(route);
        STAGE.setResizable(false);
        show();
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

    private static void show() {
        StageFactory.STAGE.show();
    }

}
