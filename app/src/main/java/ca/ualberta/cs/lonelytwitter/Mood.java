package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bschreib on 9/16/15.
 */
public abstract class Mood {

    private Date date;


    //Constructors, one that takes in a date, another that does not
    public Mood(Date date) {
        this.date = date;
    }

    public Mood() {
        this.date = new Date();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //General String that each mood returns differently
    public abstract String moodString();
}

