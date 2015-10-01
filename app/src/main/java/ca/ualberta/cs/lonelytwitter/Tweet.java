package ca.ualberta.cs.lonelytwitter;

<<<<<<< HEAD
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
=======
import java.io.IOException;
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
>>>>>>> f15IOlab
    }

    public String getText() {
        return text;
    }

<<<<<<< HEAD
    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Tweet was too long");
        }
    }

    public abstract Boolean isImportant();

=======
    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            //throw new TweetTooLongException();
        }
    }

    @Override
    public String toString() {
        return date.toString() + " || " + this.text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();
>>>>>>> f15IOlab

}
