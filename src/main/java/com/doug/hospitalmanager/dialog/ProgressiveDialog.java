package com.doug.hospitalmanager.dialog;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.Objects;

public class ProgressiveDialog extends Thread {

    private static final JDialog dialog = new JDialog();;
    private static Thread thread;

    public static void show() {
        if (thread != null) {
            thread.interrupt();
        }

        thread = new Thread(() -> {
            var loadingIcon = new ImageIcon(Objects.requireNonNull(ProgressiveDialog.class.getResource("/images/loading.gif")));
            var label = new JLabel("Carregando...", loadingIcon, SwingConstants.CENTER);

            dialog.setUndecorated(true);
            dialog.setContentPane(label);
            dialog.setSize(new Dimension(300, 300));
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });

        thread.start();
    }

    public static void close() {
        dialog.dispose();
        thread.interrupt();
    }

}
