package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AttendeeHome {


    @FXML
    public Label AttendeeHomeName;
    @FXML
    public Label AttendeeHomeEventCardName;
    @FXML
    public Label AttendeeHomeEventCardDesc;
    @FXML
    public  Label AttendeeHomeEventCardFare;
    @FXML
    public Label AttendeeHomeEventCardVenue;


    public void setAttendeeHomeName(String name){
        AttendeeHomeName.setText(name);
    }


    public void LoadEventsAttendee() throws SQLException {

        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events;";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);
        while (queryresult.next()){
            AttendeeHomeEventCardName.setText(queryresult.getString("event_name"));
            AttendeeHomeEventCardDesc.setText(queryresult.getString("event_description"));
            AttendeeHomeEventCardFare.setText(Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket"));
            AttendeeHomeEventCardVenue.setText(queryresult.getString("venue"));

        }

    }
}
