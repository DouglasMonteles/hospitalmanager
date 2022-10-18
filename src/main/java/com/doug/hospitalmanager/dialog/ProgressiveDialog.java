package com.doug.hospitalmanager.dialog;

import com.doug.hospitalmanager.swing.SwingFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ProgressiveDialog extends Thread {

    private static final String LOADING_ICON_PATH = "/images/loading.gif";

    private static JDialog dialog;
    private static Thread thread;

    public static void show() {
        if (thread != null) {
            thread.interrupt();
        }

        thread = new Thread(() -> {
            var loadingIcon = SwingFactory.buildImageIcon(LOADING_ICON_PATH);
            var label = SwingFactory.buildCenteredJLabelWithIcon("Carregando", loadingIcon);

            dialog = SwingFactory.buildLoadingJDialog(label);
            dialog.setVisible(true);
        });

        thread.start();
    }

    public static void close() {
        dialog.dispose();
        thread.interrupt();
    }

}
