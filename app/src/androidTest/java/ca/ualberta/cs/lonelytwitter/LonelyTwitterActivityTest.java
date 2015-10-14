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

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        activity.getTweets().clear();

        EditText bodyText = activity.getBodyText();
        String testString = "test tweet";
        bodyText.setText(testString);

        Button saveButton = activity.getSaveButton();
        saveButton.performClick();

        ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals(tweet.getText(), testString);
    }
}