package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

public class OrgAddEvent {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void GoToDashboard(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrgDashboard.fxml"));
        stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



        @FXML
        protected TextField EventName;
        @FXML
        protected TextArea EventDescription;
        @FXML
        protected TextField GuestName;
        @FXML
        protected TextField OrganizerName;
        @FXML
        protected TextField OrganizerId;
        @FXML
        protected TextField MobileNumber;

        @FXML
        protected TextField EventVenue;

        @FXML
        protected DatePicker DatePick;

        @FXML
        protected void AddEventButtonAction(MouseEvent e){

            if(!EventName.getText().isBlank() && !EventDescription.getText().isBlank() && !GuestName.getText().isBlank() && !OrganizerId.getText().isBlank() && !OrganizerName.getText().isBlank() && !MobileNumber.getText().isBlank() && !EventVenue.getText().isBlank() ){
                OrgcreateEvent();
            }
        }
        public void OrgcreateEvent() {
            DBConnection connect = new DBConnection();
            Connection connection = connect.getConnection();

            Random rand = new Random();
            int x = rand.nextInt(100000);

            String insertQuery = "insert into events(eventId,event_name,event_description,venue,event_date,created_at,org_mob_number,guest,ticket_fare,org_id,org_name,no_of_attendees,total_tickets,tickets_remaining) values("+x+",'"+EventName.getText()+"','"+EventDescription.getText()+"','"+EventVenue.getText()+"','"+DatePick.getValue()+"','2023-01-10 10:39:37','"+Integer.valueOf(MobileNumber.getText())+"','"+GuestName.getText()+"',800,'"+OrganizerId.getText()+"','"+OrganizerName.getText()+"',0,400,100)";

            try {
                Statement statement = connection.createStatement();
                int queryResult = statement.executeUpdate(insertQuery);

                System.out.println("QueryRes    " + queryResult);

                if (queryResult == 1) {
                    System.out.println("Value Inserted");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
