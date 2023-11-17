module com.j4n_r {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires java.net.http;

    opens com.j4n_r to javafx.fxml;
    exports com.j4n_r;
}