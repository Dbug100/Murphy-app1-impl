package baseline;
/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Deaja Murphy
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventList {
    private String description;
    private String date;

    public EventList(LocalDate date, String description){
        this.setDescription(description);
        setDate(date);
    }

    public EventList(String description){
        this.setDescription(description);
        date = " ";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate dateGiven) {
        //string pattern for date picker
        //date time formatter
        if(dateGiven == null){
            this.date = " ";
        }else{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = dateGiven.format(formatter);
        }
    }

    @Override
    public String toString() {
        return "At: " + date + description;
    }
}
