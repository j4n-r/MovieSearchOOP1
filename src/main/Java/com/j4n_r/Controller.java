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
        APIsearch request = new APIsearch();
        java.util.List<Movie> movies = request.apiSearchRequest(searchField.getText());
        resultListView.getItems().clear();
        // loop through array and print it out

        for (Movie movie : movies) {
            String title = "Title: " + movie.getTitle();
            String  year = "Year: " + movie.getYear();
            String IMDb_ID = ("IMDb ID: " + movie.getImdbID());
            String type = "Type: " + movie.getType();
            String placeHolder = "\n";
            resultListView.getItems().addAll(title, year, IMDb_ID, type, placeHolder);
        }


    }

    @FXML
    void searchFieldOnAction(ActionEvent event) {

    }

}
