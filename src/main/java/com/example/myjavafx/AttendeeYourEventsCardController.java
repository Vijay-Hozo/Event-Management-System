package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Map;

public class AttendeeYourEventsCardController {

    @FXML
    private Label AttendeeYourEventCardDesc;

    @FXML
    private Label AttendeeYourEventCardName;

    @FXML
    private Label AttendeeYourEventCardVenue;

    public void setAttEventCardDetails(Map<String,String> CardDetails){

        AttendeeYourEventCardName.setText(CardDetails.get("EventName"));
        AttendeeYourEventCardVenue.setText(CardDetails.get("EventVenue"));
        AttendeeYourEventCardDesc.setText(CardDetails.get("EventDesc"));

    }
}
