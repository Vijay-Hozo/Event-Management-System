package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrgDashboard2 {

    @FXML
    private Label OrgDashboardName;

    @FXML
    private Label OrgEventCardName;
    @FXML
    private Label OrgEventCardVenue;
    @FXML
    private Label OrgEventCardNoofAttendees;
    @FXML
    private Label OrgEventCardTicketAvail;
    @FXML
    private Label OrgEventCardTicketFare;



    public void setName(String name){
        OrgDashboardName.setText(name.toUpperCase());
    }

    public void LoadEventsOrg(String OrgId) throws SQLException {

        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events where org_id='"+OrgId+"';";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);
        while (queryresult.next()){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("models/OrgEventCard.fxml"));
            //VBox cardBox = fxmlLoader.load();
            OrgEventCardController cardController = fxmlLoader.getController();
            OrgEventCardName.setText(queryresult.getString("event_name"));
            OrgEventCardVenue.setText(queryresult.getString("venue"));
            OrgEventCardNoofAttendees.setText(Integer.toString(queryresult.getInt("no_of_attendees")).concat(" Attending"));
            OrgEventCardTicketAvail.setText(Integer.toString(queryresult.getInt("tickets_remaining")).concat(" tickets available"));
            OrgEventCardTicketFare.setText(Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket"));
        }

    }



    public class OrgEventCardLoader implements Initializable {


        @FXML
        VBox OrgDashboardVbox;

        private List<OrgEventCardModel> OrganizerEvents;

        @FXML
        private URL url;
        @FXML
        private ResourceBundle resourceBundle;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            OrganizerEvents = new ArrayList<>(OrgEvents());

            try {
                for (int i =0 ; i<OrgEvents().size() ; i++){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("models/OrgEventCard.fxml"));
                    VBox cardBox = fxmlLoader.load();
                    OrgEventCardController cardController = fxmlLoader.getController();
                    cardController.setOrgEventCardData(OrganizerEvents.get(i));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        private List<OrgEventCardModel> OrgEvents(){

            List<OrgEventCardModel> ls = new ArrayList<>();

            OrgEventCardModel card = new OrgEventCardModel();
            card.setOrgEventCardName("Dhrona 2k23");
            card.setOrgEventCardNoofAttendees("200");
            card.setOrgEventCardTicketAvail("150");
            card.setOrgEventCardVenue("Open air theatre");
            card.setOrgEventCardTicketFare("500");
            ls.add(card);

            card = new OrgEventCardModel();
            card.setOrgEventCardName("Thrishul 2k23");
            card.setOrgEventCardNoofAttendees("150");
            card.setOrgEventCardTicketAvail("100");
            card.setOrgEventCardVenue("Open air theatre 2");
            card.setOrgEventCardTicketFare("250");
            ls.add(card);

            card = new OrgEventCardModel();
            card.setOrgEventCardName("Pragya 2k23");
            card.setOrgEventCardNoofAttendees("100");
            card.setOrgEventCardTicketAvail("80");
            card.setOrgEventCardVenue("Auditorium 2");
            card.setOrgEventCardTicketFare("150");
            ls.add(card);

            return ls;
        }
    }





    // Navigations

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void GoToCreateEvent(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrgAddEvent.fxml"));
        stage =  (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
