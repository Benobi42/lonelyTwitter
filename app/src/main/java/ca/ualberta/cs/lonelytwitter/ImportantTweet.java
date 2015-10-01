package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
<<<<<<< HEAD
 * Created by bschreib on 9/16/15.
 */
public class ImportantTweet extends Tweet{
    //extends allows the class to inherit the attributes and methods of the parent (super) class
    //if a class has no extends class, then it's parent class it the Object class
    //Class names use "camelcase", with each new word having a Capital at the beginning
    //Method names use camelcase, but the first letter is lower case

    public ImportantTweet(String tweet, Date date) {
        //super initializes an instance of the parent class
        //cannot access private data within the parent class
        super(tweet, date);
=======
 * Created by joshua2 on 9/16/15.
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
>>>>>>> f15IOlab
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
<<<<<<< HEAD

    }
=======
    }

>>>>>>> f15IOlab
}
