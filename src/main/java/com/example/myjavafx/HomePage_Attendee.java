package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage_Attendee {

    @FXML
    VBox AttendeeHomeEventsVbox;
    @FXML
    VBox AttendeeHomeYourEventsVbox;
    @FXML
    Label AttendeeHomeName;

    public void setAttendeeHomeName(String name){
        AttendeeHomeName.setText(name.toUpperCase());
    }


    public void LoadEventsAttendee() throws SQLException, IOException {


        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events;";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);

        while (queryresult.next()){
            Map<String,String> queryResultModel2=new HashMap<String,String>();


            String EventName = queryresult.getString("event_name");
            String EventDesc = queryresult.getString("event_description");
            String EventVenue = queryresult.getString("venue");
            String EventTicketFare = Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket");

            queryResultModel2.put("EventName",EventName);
            queryResultModel2.put("EventVenue",EventVenue);
            queryResultModel2.put("EventDesc",EventDesc);
            queryResultModel2.put("EventTicketFare",EventTicketFare);

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("models/AttEventCard.fxml"));
            Pane cardBox = fxmlLoader.load();
            AttendeeEventCardController cardController = fxmlLoader.getController();
            cardController.setAttEventCardDetails(queryResultModel2);
            AttendeeHomeEventsVbox.getChildren().add(cardBox);

        }
}

    public void LoadYourEventsAttendee() throws SQLException, IOException {


        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events ;";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);

        while (queryresult.next()){
            Map<String,String> queryResultModel2=new HashMap<String,String>();


            String EventName = queryresult.getString("event_name");
            String EventDesc = queryresult.getString("event_description");
            String EventVenue = queryresult.getString("venue");
            String EventTicketFare = Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket");

            queryResultModel2.put("EventName",EventName);
            queryResultModel2.put("EventVenue",EventVenue);
            queryResultModel2.put("EventDesc",EventDesc);
            queryResultModel2.put("EventTicketFare",EventTicketFare);

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("models/AttYourEventsCard.fxml"));
            Pane YourCardBox = fxmlLoader.load();
            AttendeeYourEventsCardController YourCardController = fxmlLoader.getController();
            YourCardController.setAttEventCardDetails(queryResultModel2);
            AttendeeHomeYourEventsVbox.getChildren().add(YourCardBox);
            
        }
    }
}
