package baseline;
/*
 *  UCF COP3330 Summer 2021 Application Assignment 2 Solution
 *  Copyright 2021 Deaja Murphy
 */
import java.time.LocalDate;

public class EventList {
    private String description;
    private LocalDate date;
    //string pattern for date picker
    //date time formatter


    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public EventList(LocalDate date, String description){
        this.setDate(date);
        this.setDescription(description);
    }

    public LocalDate getDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "At: " + date + description;
    }
}
