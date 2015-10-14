package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweet extends Tweet{
    //extends allows the class to inherit the attributes and methods of the parent (super) class
    //if a class has no extends class, then it's parent class it the Object class
    //Class names use "camelcase", with each new word having a Capital at the beginning
    //Method names use camelcase, but the first letter is lower case

    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getText() {
        return "!!!" + super.getText();
    }

}
