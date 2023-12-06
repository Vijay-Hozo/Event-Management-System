module com.example.myjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.myjavafx to javafx.fxml;
    exports com.example.myjavafx;
}