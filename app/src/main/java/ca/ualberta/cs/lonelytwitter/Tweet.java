package ca.ualberta.cs.lonelytwitter;

import android.text.BoringLayout;

import java.util.Date;

/**
 * Created by bschreib on 9/16/15.
 */
public abstract class Tweet {

    private String text;
    private Date date;

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
        }
    }

    public abstract Boolean isImportant();
}
