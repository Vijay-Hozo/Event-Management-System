package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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




    public void LoadEventsAttendee() throws SQLException, IOException {

        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events;";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);
        while (queryresult.next()){
            List<String> queryResultModel = new ArrayList<>();
            Map<String,String> queryResultModel2=new HashMap<String,String>();

            String EventName = queryresult.getString("event_name");
            String EventVenue = queryresult.getString("venue");
            String EventNoofAttendees = Integer.toString(queryresult.getInt("no_of_attendees")).concat(" Attending");
            String EventTicketAvail = Integer.toString(queryresult.getInt("tickets_remaining")).concat(" tickets available");
            String EventTicketFare = Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket");

            queryResultModel2.put("EventName",EventName);
            queryResultModel2.put("EventVenue",EventVenue);
            queryResultModel2.put("EventNoofAttendees",EventNoofAttendees);
            queryResultModel2.put("EventTicketAvail",EventTicketAvail);
            queryResultModel2.put("EventTicketFare",EventTicketFare);


            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("models/AttEventCard.fxml"));
            Pane cardBox = fxmlLoader.load();
            OrgEventCardController cardController = fxmlLoader.getController();

//            A.getChildren().add(cardBox);
        }

    }
}
