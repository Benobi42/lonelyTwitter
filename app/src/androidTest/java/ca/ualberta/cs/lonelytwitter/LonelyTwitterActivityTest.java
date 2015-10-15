package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.AdapterView;
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
        final LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
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
        getInstrumentation().waitForIdleSync();
        //Click on Tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                AdapterView v = (AdapterView) oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();

        //Ensure that the TweetEditor Activity Starts up
        //Code taken from https://developer.android.com/training/activity-testing/activity-functional-testing.html
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor editTweetActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        // Validate that ReceiverActivity is started
        EditTweetActivity editTweetActivity = (EditTweetActivity)
                editTweetActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", editTweetActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, editTweetActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, editTweetActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(editTweetActivityMonitor);
    }
}