package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private String testString;
    private Button saveButton;
    private ListView oldTweetsList;
    private EditText bodyText;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        activity.getTweets().clear();
        saveButton = activity.getSaveButton();
        oldTweetsList = activity.getOldTweetsList();
        bodyText = activity.getBodyText();
        testString = "test tweet";
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText(testString);
                saveButton.performClick();
                Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
                assertEquals(tweet.getText(), testString);
            }
        });



    }
}