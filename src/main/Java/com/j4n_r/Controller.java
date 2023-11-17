package com.j4n_r;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private ListView<String> resultListView;
    @FXML
    void searchButtonOnAction(ActionEvent event) {
        String searchTerm = searchField.getText();
        resultListView.getItems().clear();
        resultListView.getItems().addAll("Result 1", "Result 2", "Result 3");
    }

    @FXML
    void searchFieldOnAction(ActionEvent event) {

    }

}
