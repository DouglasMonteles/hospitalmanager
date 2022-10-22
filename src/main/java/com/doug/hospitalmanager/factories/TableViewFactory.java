package com.doug.hospitalmanager.factories;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewFactory {

    public static <S, T> TableColumn<S, T> buildColumn(String columnName, String value) {
        var column = new TableColumn<S, T>(columnName);

        column.setCellValueFactory(new PropertyValueFactory<>(value));

        return column;
    }

}
