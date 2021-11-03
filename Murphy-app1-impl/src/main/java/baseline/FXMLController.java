package baseline;
/*
 *  UCF COP3330 Summer 2021 Application Assignment 2 Solution
 *  Copyright 2021 Deaja Murphy
 */
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    Button addButton;
    @FXML
    Button deleteButton;
    @FXML
    TextField addDescription;
    @FXML
    DatePicker selectDate;
    @FXML
    ListView<EventList> toDoList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //event searializer to prevent duplicates

    }


    @FXML
    private void addEvent(Event e){
        var newEvent = new EventList(selectDate.getValue(), addDescription.getText());
        //add new event to toDoList

        //empty text field and set calendar to today's date
        // selectDate.setValue(LocalDate.now());
    }
    @FXML
    private void deleteEvent(Event e){
        //for length of current list
        //search for event
        //splice

    }
    @FXML
    public Object[] getEvent(){
        // return toDoList
        return toDoList.getItems().toArray();
    }
}
