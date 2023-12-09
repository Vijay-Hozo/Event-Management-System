package com.example.myjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class OrgEditEvent {

    @FXML
    private TextArea EditEventDescription;

    @FXML
    private TextField EditEventName;

    @FXML
    private TextField EditEventVenue;

    @FXML
    private TextField EditMobileNumber;

    @FXML
    private TextField EditOrganizerId;

    @FXML
    private TextField EditOrganizerName;

    @FXML
    private TextField EditguestName;

    @FXML
    private DatePicker EditDatePick;


    public void setEditEventDetails(String EventId) throws SQLException {

        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events where eventId='"+EventId+"';";


        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);


        while (queryresult.next()){


        EditEventName.setText(queryresult.getString("event_name"));
        EditEventDescription.setText(queryresult.getString("event_description"));
        EditEventVenue.setText(queryresult.getString("venue"));
        EditguestName.setText(queryresult.getString("guest"));
        EditOrganizerName.setText(queryresult.getString("org_name"));
        EditOrganizerId.setText(queryresult.getString("org_id"));
        EditMobileNumber.setText((queryresult.getString("org_mob_number")));
        EditDatePick.setValue(queryresult.getDate("event_date").toLocalDate());
        }

    }



    public void UpdateEventButton(String OrgId) throws SQLException {

        DBConnection connect =  new DBConnection();
        Connection connectDb =connect.getConnection();

        String getEventsQuery = "select * from events where org_id='"+OrgId+"';";

        Statement statement = connectDb.createStatement();
        ResultSet queryresult= statement.executeQuery(getEventsQuery);
        while (queryresult.next()){

//            E.setText(Integer.toString(queryresult.getInt("no_of_attendees")).concat(" Attending"));
//            OrgEventCardTicketAvail.setText(Integer.toString(queryresult.getInt("tickets_remaining")).concat(" tickets available"));
//            OrgEventCardTicketFare.setText(Integer.toString(queryresult.getInt("ticket_fare")).concat(" /ticket"));
        }
        updateevent();

    }
    public void updateevent(){
        DBConnection connect = new DBConnection();
        Connection connection = connect.getConnection();
        String updateQuery = String.format("update organizer set event_name='%s',venue='%s',event_description='%s',org_name='%s',org_mob_number='%s');",EditEventName.getText(),EditEventVenue.getText(),EditEventDescription.getText(),EditOrganizerName.getText(),Integer.parseInt(EditMobileNumber.getText()));

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
            String updateinsertQuery = "update events set event_name='"+EditEventName.getText()+"',event_description='"+EditEventDescription.getText()+"',venue='"+EditEventVenue.getText()+"',event_date='"+EditDatePick.getValue()+"',created_at='2023-12-09 10:39:37',org_mob_number='"+Integer.valueOf(EditMobileNumber.getText())+"',guest='"+EditguestName.getText()+"',ticket_fare=100,org_id='"+EditOrganizerId.getText()+"',org_name='"+EditOrganizerName.getText()+"',no_of_attendees=300,total_tickets=350,tickets_remaining=50 where eventId='1234'";


//            UPDATE table_name
//
//            SET column_name1= value1, column_name2= value2


        } catch (Exception e) {
            e.printStackTrace();
      }
}


public void DeleteEvent(MouseEvent event) throws SQLException {

    DBConnection connect =  new DBConnection();
    Connection connection = connect.getConnection();

    String deleteQuery = "delete from events where event_name='"+EditEventName.getText()+"';";

    Statement statement = connection.createStatement();
    statement.executeUpdate(deleteQuery);

    System.out.println("Record deleted ");


}
}

