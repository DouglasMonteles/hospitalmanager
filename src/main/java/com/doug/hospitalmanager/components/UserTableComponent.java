package com.doug.hospitalmanager.components;

import com.doug.hospitalmanager.factories.TableViewFactory;
import com.doug.hospitalmanager.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class UserTableComponent {

    public TableView<User> build(List<User> users) {
        var table = new TableView<User>();

        var idColumn = TableViewFactory.<User, Long>buildColumn("Id", "id");
        var nameColumn = TableViewFactory.<User, String>buildColumn("Nome", "name");
        var usernameColumn = TableViewFactory.<User, String>buildColumn("Nome de usuário", "email");
        var birthDateColumn = TableViewFactory.<User, LocalDate>buildColumn("Data de Nasc.", "birthDate");

        var data = FXCollections.observableArrayList(users);

        table.getColumns().addAll(List.of(
                idColumn,
                nameColumn,
                usernameColumn,
                birthDateColumn
        ));

        table.setItems(data);

        return table;
    }

}
