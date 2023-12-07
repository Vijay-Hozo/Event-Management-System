package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;

public class SignUpController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    // SignUpAsAttendee Details  & Methods

    @FXML
    private TextField SignUpAsAttendeeUserName;
    @FXML
    private TextField SignUpAsAttendeeEmail;
    @FXML
    private TextField SignUpAsAttendeePassword;
    @FXML
    private TextField SignUpAsAttendeeMobilenumber;


    public  void InsertInDB(){

        DBConnection connect = new DBConnection();
        Connection connectDB = connect.getConnection();


        String insertQuery = "insert into users(userId,username,email,password,mobilenumber) values(2,'japan','japan@gmail.com','japan',9099090909);";

        try {
            Statement statement = connectDB.createStatement();
            int queryResult = statement.executeUpdate(insertQuery);

            System.out.println("QueryRes    "+queryResult);

            if (queryResult==1){
                System.out.println("Value Inserted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // SignUp Button Action

    public void HandleCreateAccount(MouseEvent e){
        if (!SignUpAsAttendeeUserName.getText().isBlank() && !SignUpAsAttendeePassword.getText().isBlank() && !SignUpAsAttendeeEmail.getText().isBlank() && !SignUpAsAttendeeMobilenumber.getText().isBlank()){
            InsertInDB();
        }
    }

    public void GetSignUpAsAttendeeDetails(MouseEvent event){


    }

    // SignUpAsAttendee Details

    @FXML
    private TextField SignUpAsOrgUserName;
    @FXML
    private TextField SignUpAsOrgId;
    @FXML
    private TextField SignUpAsOrgEmail;
    @FXML
    private TextField SignUpAsOrgPassword;
    @FXML
    private TextField SignUpAsOrgMobilenumber;





    // Navigations

    public void BackToHome(MouseEvent event) throws IOException {
        System.out.println("Back Home");
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
}
