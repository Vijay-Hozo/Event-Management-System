package com.example.myjavafx;

 import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("Home.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1070, 716);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Event Management System");
        stage.setScene(scene);

        stage.setResizable(false);

       Font.loadFont(getClass().getResourceAsStream("fonts/Poppins-Black.ttf"),20);
       Font.loadFont(getClass().getResourceAsStream("fonts/Poppins-ExtraBold.ttf"),42);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}