package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
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
    @FXML
    private Label OrgEventCardEventId;


    public void setOrgEventCardData(Map<String,String> CardDetails){

        OrgEventCardName.setText(CardDetails.get("EventName"));
        OrgEventCardNoofAttendees.setText(CardDetails.get("EventNoofAttendees"));
        OrgEventCardTicketAvail.setText(CardDetails.get("EventTicketAvail"));
        OrgEventCardTicketFare.setText(CardDetails.get("EventTicketFare"));
        OrgEventCardVenue.setText(CardDetails.get("EventVenue"));
        OrgEventCardEventId.setText(CardDetails.get("EventId"));
    }

    public void handleEditButton(MouseEvent event) throws IOException, SQLException {
        System.out.println("Event Id "+OrgEventCardEventId.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrgEditEvent.fxml"));
        Parent root = loader.load();

        OrgEditEvent controller = loader.getController();

        controller.setEditEventDetails(OrgEventCardEventId.getText());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
}
