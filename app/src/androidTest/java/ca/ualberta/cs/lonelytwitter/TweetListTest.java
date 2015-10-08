package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;


public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    private ArrayList<MyObservable> observables = new ArrayList<MyObservable>();

    private boolean wasNotified = false;

    public void myNotify(){
        wasNotified = true;
    }

    /*
    Test Cases Written During Lab
    public void testDeleteTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        tweetList.addTweet(tweet);
        tweetList.deleteTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        tweetList.addTweet(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((returnedTweet.getDate().equals(tweet.getDate())) && (tweet.getText().equals(returnedTweet.getText())));
    }*/

    public void testAddTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
        boolean exceptionCaught = false;
        try {
            tweetList.addTweet(tweet);
        } catch(IllegalArgumentException e){
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);

    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList();
        Tweet tweet0 = new NormalTweet("This is Tweet 0");
        tweetList.addTweet(tweet0);
        Tweet tweet1 = new NormalTweet("This is Tweet 1");
        tweetList.addTweet(tweet1);
        Tweet tweet2 = new NormalTweet("This is Tweet 2");
        tweetList.addTweet(tweet2);
        ArrayList <Tweet> GottenTweets = tweetList.getTweets();
        assertTrue((GottenTweets.get(0).equals(tweet0)) && (GottenTweets.get(1).equals(tweet1)) && (GottenTweets.get(2).equals(tweet2)));
    }

    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testRemoveTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihihi");
        tweetList.addTweet(tweet);
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweetList = new TweetList();
        assertTrue(tweetList.getCount() == (0));
        Tweet tweet0 = new NormalTweet("This is the First Tweet");
        tweetList.addTweet(tweet0);
        assertTrue(tweetList.getCount() == (1));
        Tweet tweet1 = new NormalTweet("This is the Second Tweet");
        tweetList.addTweet(tweet1);
        assertTrue(tweetList.getCount() == (2));
        tweetList.removeTweet(tweet1);
        assertTrue(tweetList.getCount() == (1));
    }

    public void testTweetChanged(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("This is a Tweet");
        tweetList.addObserver(this);
        wasNotified = false;
        assertFalse(wasNotified);
        tweetList.addTweet(tweet);
        assertTrue(wasNotified);
    }
}