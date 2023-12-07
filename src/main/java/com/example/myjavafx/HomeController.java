package com.example.myjavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SetStage(Stage st) {
        stage = st;
    }


    public void LoginAsOrg(MouseEvent event) throws IOException {
        System.out.println("Org Login");
        root = FXMLLoader.load(getClass().getResource("LoginAsOrganizer.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void LoginAsAttendee(MouseEvent event) throws IOException {
        System.out.println("Attendtee Login");
        root = FXMLLoader.load(getClass().getResource("LoginAsAttendee.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void GoToSignUpOrg(MouseEvent event) throws IOException {
        System.out.println("SignUp Org");
        root = FXMLLoader.load(getClass().getResource("SignUpAsOrganizer.fxml"));
        System.out.println("Root "+root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToSignUpAttendee(MouseEvent event) throws IOException {
        //System.out.println("SignUpAtt");
        Parent root = FXMLLoader.load(getClass().getResource("SignUpAsAttendee.fxml"));
        stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}