package ca.ualberta.cs.lonelytwitter;

import android.text.BoringLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

/**
 * Created by bschreib on 9/16/15.
 */
public abstract class Tweet implements Tweetable{

    private String text;
    private Date date;
    private ArrayList<Mood>  moodList = new ArrayList <Mood>();

    public Tweet(String tweet, Date date) {
        this.setText(tweet);
        this.setDate(date);
    }

    public Tweet(String tweet) {
        this.setText(tweet);
        this.setDate(new Date());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweet was too long");
        }
    }

    public abstract Boolean isImportant();


}
