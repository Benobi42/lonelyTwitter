package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bschreib on 9/16/15.
 */
public class Happy extends Mood {

    public Happy(Date date) {
        super(date);
    }

    public Happy() {
    }

    public String moodString(){
        return "Feeling Happy! :)";
    }
}
