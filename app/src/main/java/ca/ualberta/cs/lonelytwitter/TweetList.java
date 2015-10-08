package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList implements MyObservable{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addTweet(Tweet tweet){
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Tweet Already Exists");
        }
        tweets.add(tweet);
        notifyObservers();
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }

    public void notifyObservers(){
        for (MyObserver i: observers){
            i.myNotify();
        }
    }

   public void addObserver(MyObserver o){
        observers.add(o);
    }


}
