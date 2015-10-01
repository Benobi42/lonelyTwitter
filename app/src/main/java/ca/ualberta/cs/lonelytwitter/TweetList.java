package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by bschreib on 9/30/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public void addTweet(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Tweet Already Exists");
        }
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets(){
        ArrayList<Tweet> tweetsCopy = tweets;
        return tweetsCopy;
    }

    public int getCount(){
        int count = tweets.size();
        return count;
    }


}
