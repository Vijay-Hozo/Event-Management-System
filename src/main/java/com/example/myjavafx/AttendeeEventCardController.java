package com.example.myjavafx;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class AttendeeEventCardController {


    @FXML
    private Label AttendeeEventCardDesc;

    @FXML
    private Label AttendeeEventCardFare;

    @FXML
    private Label AttendeeEventCardName;

    @FXML
    private Label AttendeeEventCardVenue;

    public void setAttEventCardDetails(Map<String,String> CardDetails){

        AttendeeEventCardName.setText(CardDetails.get("EventName"));
        AttendeeEventCardDesc.setText(CardDetails.get("EventDesc"));
        AttendeeEventCardFare.setText(CardDetails.get("EventTicketFare"));
        AttendeeEventCardVenue.setText(CardDetails.get("EventVenue"));

    }


}
