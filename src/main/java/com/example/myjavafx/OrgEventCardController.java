package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Map;

public class OrgEventCardController {
    @FXML
    private Label OrgEventCardName;

    @FXML
    private Label OrgEventCardNoofAttendees;

    @FXML
    private Label OrgEventCardTicketAvail;

    @FXML
    private Label OrgEventCardTicketFare;

    @FXML
    private Label OrgEventCardVenue;


    public void setOrgEventCardData(Map<String,String> CardDetails){

        OrgEventCardName.setText(CardDetails.get("EventName"));
        OrgEventCardNoofAttendees.setText(CardDetails.get("EventNoofAttendees"));
        OrgEventCardTicketAvail.setText(CardDetails.get("EventTicketAvail"));
        OrgEventCardTicketFare.setText(CardDetails.get("EventTicketFare"));
        OrgEventCardVenue.setText(CardDetails.get("EventVenue"));
    }
}
