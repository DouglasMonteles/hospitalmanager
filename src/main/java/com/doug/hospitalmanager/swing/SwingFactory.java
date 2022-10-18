package com.doug.hospitalmanager.swing;

import com.doug.hospitalmanager.dialog.ProgressiveDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SwingFactory {

    public static JLabel buildCenteredJLabelWithIcon(String title, ImageIcon icon) {
        return new JLabel(title, icon, SwingConstants.CENTER);
    }

    public static ImageIcon buildImageIcon(String path) {
        var urlImg = Objects.requireNonNull(ProgressiveDialog.class.getResource(path));
        return new ImageIcon(urlImg);
    }

    public static JDialog buildLoadingJDialog(JLabel label) {
        var dialog = new JDialog();

        dialog.setUndecorated(true);
        dialog.setContentPane(label);
        dialog.setSize(new Dimension(300, 300));
        dialog.setLocationRelativeTo(null);

        return dialog;
    }

}
