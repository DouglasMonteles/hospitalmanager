package com.doug.hospitalmanager;

import com.doug.hospitalmanager.dialog.ProgressiveDialog;
import com.doug.hospitalmanager.routes.Routes;
import com.doug.hospitalmanager.routes.StageFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

public class JavaFxApplication extends Application {

    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        ProgressiveDialog.show();
        SpringApplication.run(HospitalmanagerApplication.class)
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    @Override
    public void start(Stage stage) {
        ProgressiveDialog.close();
        StageFactory.showStageNotResizable(Routes.LOGIN);
    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
    }

}
