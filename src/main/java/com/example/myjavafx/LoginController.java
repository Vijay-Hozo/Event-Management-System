package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField OrganizerId;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField LogInUsername;

    public void GetLoginDetails(MouseEvent event) throws IOException {
        System.out.println(LogInUsername.getText());
        System.out.println(OrganizerId.getText());
    }



    public void BackToHome(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
