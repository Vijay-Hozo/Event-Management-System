package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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


    public void setOrgEventCardData(OrgEventCardModel Card){

        OrgEventCardName.setText(Card.getOrgEventCardName());
        OrgEventCardNoofAttendees.setText(Card.getOrgEventCardNoofAttendees());
        OrgEventCardTicketAvail.setText(Card.getOrgEventCardTicketAvail());
        OrgEventCardTicketFare.setText(Card.getOrgEventCardTicketFare());
        OrgEventCardVenue.setText(Card.getOrgEventCardVenue());
    }
}
