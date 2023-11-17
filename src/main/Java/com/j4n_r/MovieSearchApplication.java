package com.j4n_r;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieSearchApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MovieSearchApplication.class.getResource("/movieSearch.fxml"));
            Controller controller = new Controller();
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            stage.setTitle("Movie Search");
            stage.setScene(scene);
            stage.show();
        }

    public static void main(String[] args) {
        launch();
    }
}
