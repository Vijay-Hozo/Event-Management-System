package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {


    private Stage stage;
    private Scene scene;
    private Parent root;



    // Organizer Login Methods
    @FXML
    protected TextField OrganizerUsername;
    @FXML
    protected TextField OrganizerId;
    @FXML
    protected TextField OrganizerPassword;
    @FXML
    protected void HandleOrgLoginButton(MouseEvent e) {
        if(OrganizerUsername.getText().isBlank() == false && OrganizerPassword.getText().isBlank() == false && OrganizerId.getText().isBlank()==false){
            validateOrganizerLogin(e);
        }
    }
    public void validateOrganizerLogin(MouseEvent e) {
        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String verifyLogin = "select count(1) from organizer where username='"+OrganizerUsername.getText()+"' and password='"+OrganizerPassword.getText()+"'and organizerId='"+OrganizerId.getText()+"'";
        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryresult= statement.executeQuery(verifyLogin);
            while(queryresult.next()){

                if(queryresult.getInt(1)==1){
                    System.out.println("Login Success");

                    GoToOrgDashboard(e);  // Navigation

                }
                else{
                    System.out.println("Enter correct Username and Password...!");
                }
            }

        } catch (SQLException eve) {
            eve.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    // Attendee Login Methods

    @FXML
    private TextField AttendeeUsername;
    @FXML
    private TextField AttendeePassword;
    @FXML
    protected void HandleAttendeeLoginButton(MouseEvent e) {
        if(AttendeeUsername.getText().isBlank() == false && AttendeePassword.getText().isBlank() == false){
            validateAttendeeLogin(e);
        }
    }
    public void validateAttendeeLogin(MouseEvent e) {
        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String verifyLogin = "select count(1) from attendee where username='"+AttendeeUsername.getText()+"' and password='"+AttendeePassword.getText()+"'";
        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryresult= statement.executeQuery(verifyLogin);
            while(queryresult.next()){

                if(queryresult.getInt( 1)==1){
                    System.out.println("Login Success");
                      // Navigatio
                    GoToAttendeeHome(e);
                }
                else{
                    System.out.println("Enter correct Username and Password...!");
                }
            }

        } catch (SQLException eve) {
            eve.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    // Navigations
    public void BackToHome(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void GoToOrgDashboard(MouseEvent event) throws IOException, SQLException {


        String Name = OrganizerUsername.getText();
        String OrgId = OrganizerId.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrgDashboard2.fxml"));
        root = loader.load();

        OrgDashboard2 OrgDashboardController = loader.getController();
        OrgDashboardController.setName(Name);

        OrgDashboardController.LoadEventsOrg(OrgId);


        //root = FXMLLoader.load(getClass().getResource("OrgDashboard.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void GoToAttendeeHome(MouseEvent event) throws IOException,SQLException{

        String username = AttendeeUsername.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AttendeeHome.fxml"));
        root = loader.load();

        HomePage_Attendee AttendeeHomeController = loader.getController();

        AttendeeHomeController.setAttendeeHomeName(username);
        AttendeeHomeController.LoadEventsAttendee();
        AttendeeHomeController.LoadYourEventsAttendee();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    public void GoToSignUpOrg(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpAsOrganizer.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToSignUpAttendee(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpAsAttendee.fxml"));
        stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
