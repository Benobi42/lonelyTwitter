package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;


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

    @Override
    public String toString() {
        return date.toString() + " || " + this.text;
    }

}
