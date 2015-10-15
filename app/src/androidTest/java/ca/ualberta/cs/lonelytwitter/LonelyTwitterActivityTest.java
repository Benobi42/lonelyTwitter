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
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        activity.getTweets().clear();
        saveButton = activity.getSaveButton();

        bodyText = activity.getBodyText();
        testString = "test tweet";
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText(testString);
                saveButton.performClick();

            }
        });
        getInstrumentation().waitForIdleSync();

        oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals(tweet.getText(), testString);

        //Ensure that the TweetEditor Activity Starts up
        //Code taken from https://developer.android.com/training/activity-testing/activity-functional-testing.html
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        //Click on Tweet to edit
        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();

        // Validate that ReceiverActivity is started
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //see that the editor starts up with the right tweet in it to edit
        assertEquals(receiverActivity.getTweet(), oldTweetsList.getChildAt(0));

        //test that we can edit the tweet
        String newText = "This tweet has been edited";
        receiverActivity.getTweet().setText(newText);
        assertEquals(receiverActivity.getTweet().getText(), newText);

        //test that we can save edited tweet
        final Button saveEditButton = receiverActivity.getSaveEditButton();
        receiverActivity.runOnUiThread(new Runnable() {
            public void run() {
                saveEditButton.performClick();
            }
        });

        //test that the new modified tweet is saved
        assertEquals(newText, ((Tweet) oldTweetsList.getItemAtPosition(0)).getText());

        //test that the new modified tweet is displayed on the other activity


        //Clean up activities at the end of test
        receiverActivity.finish();
    }
}