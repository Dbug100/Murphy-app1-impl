package baseline;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import javafx.scene.control.ListView;


public class FXMLController {
    @FXML
    private Button deleteButton;
    @FXML
    private TextField addDescription;
    @FXML
    private DatePicker selectDate;
    @FXML
    private ListView<String> toDoList;
    @FXML
    private ListView<String> finishedList;
    @FXML
    private ListView<String> unfinishedList;
    EventList newEvent;


    @FXML
    private void helpButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructions.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("How To");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addEvent(){
        if(selectDate.getValue()== null){
            newEvent = new EventList("\t\t\t\t"+addDescription.getText());
        }else{
            newEvent = new EventList(selectDate.getValue(), "\t"+addDescription.getText());
        }
        //add new event to toDoList
        toDoList.getItems().add(String.valueOf(newEvent));
        //empty text field and set calendar to today's date
        addDescription.setText("");
        selectDate.setValue(null);
    }
    @FXML
    private void deleteEvent(){
        final int index = toDoList.getSelectionModel().getSelectedIndex();
        if(index != -1){
            //removes the item from the list
            toDoList.getItems().remove(index);
        }
    }

    @FXML
    private void markFin(){
        //add to array of finished tasks
        //finishedList.getItems().add(String.valueOf(toDoList.getSelectionModel().getSelectedItems()));
        System.out.print(toDoList.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void markUnfin(){
        //add to array of unfinished tasks
    }

    @FXML
    private void editTask(){
        toDoList.setEditable(true);
        toDoList.setCellFactory(TextFieldListCell.forListView());
        toDoList.setOnEditCommit(t -> toDoList.getItems().set(t.getIndex(), t.getNewValue()));
    }

    @FXML
    private void viewFinButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("finished.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Finished Tasks");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void viewUnButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("unfinished.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Unfinished Tasks");
        stage.setScene(scene);
        stage.show();
    }

    //@Override
    public void initialize() {
        try {
            EventList[] events;
            events = EventSerializer.deserialize();
            toDoList.getItems().addAll(String.valueOf(events));
            finishedList.getItems().addAll(String.valueOf(events));
            unfinishedList.getItems().addAll(String.valueOf(events));
        }catch(Exception e)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("TodoFX");
            alert.setHeaderText("Events could not be loaded from file system");
        }

    }
}