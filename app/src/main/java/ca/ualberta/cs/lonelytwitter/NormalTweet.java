package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweet extends Tweet {
    public NormalTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public NormalTweet(String tweet) {
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
