package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav"; 									//Model
	private EditText bodyText;															//View
	private ListView oldTweetsList;														//Controller
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();								//Model
	private ArrayAdapter<Tweet> adapter;												//Controller
	private Button saveButton;
	private Button clearButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {									//View
		super.onCreate(savedInstanceState);												//View
		setContentView(R.layout.main);													//Controller

		bodyText = (EditText) findViewById(R.id.body);									//View
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);					//View
		saveButton = (Button) findViewById(R.id.save);									//View
		saveButton.setOnClickListener(new View.OnClickListener() {                      //Controller
			public void onClick(View v) {                                                //Controller
				setResult(RESULT_OK);                                                    //Controller
				String text = bodyText.getText().toString();                            //Controller
				tweets.add(new NormalTweet(text));                                        //Model
				saveInFile();                                                            //Model
				adapter.notifyDataSetChanged();                                            //Controller
			}
		});
		clearButton = (Button) findViewById(R.id.clear); 									//View
		clearButton.setOnClickListener(new View.OnClickListener() {                        //Controller
			public void onClick(View v) {                                                //Controller
				setResult(RESULT_OK);                                                    //Controller
				tweets.clear();                                                            //Model
				saveInFile();                                                            //Model
				adapter.notifyDataSetChanged();                                            //Controller
			}
		});
	}

	@Override
	protected void onStart() {															//View
		super.onStart();																//View
		loadFromFile();																	//Model
		adapter = new ArrayAdapter<Tweet>(this,											//Controller
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);												//Controller
		adapter.notifyDataSetChanged();													//Controller
	}

	private void loadFromFile() {														//Model
		try {																			//Model
			FileInputStream fis = openFileInput(FILENAME);								//Model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));			//Model
			Gson gson = new Gson();														//Model
			//https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
			Type arraylistType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();	//Model
			tweets = gson.fromJson(in, arraylistType);									//Model
		} catch (FileNotFoundException e) {												//Model
			tweets = new ArrayList<Tweet>();											//Model
		} catch (IOException e) {														//Model
			throw new RuntimeException(e);												//Model
		}
	}
	
	private void saveInFile() {															//Model
		try {																			//Model
			FileOutputStream fos = openFileOutput(FILENAME, 0);							//Model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));		//Model
			Gson gson = new Gson();														//Model
			gson.toJson(tweets, out);													//Model
			out.flush();																//Model
			fos.close();																//Model
		} catch (FileNotFoundException e) {												//Model
			throw new RuntimeException(e);												//Model
		} catch (IOException e) {														//Model
			throw new RuntimeException(e);												//Model
		}
	}

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public EditText getBodyText() {
		return bodyText;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}
}