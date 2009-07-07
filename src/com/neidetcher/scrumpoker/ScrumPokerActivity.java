package com.neidetcher.scrumpoker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * This is for software engineers that want to estimate stories in the agile
 * software process 'scrum'.
 * 
 * It's text-based, stupid simple; show points, pick one, display your choice,
 * go back to possible points, that's it.
 * 
 * This is not a poker game, if you don't know what scrum is then you probably
 * don't want this software!
 */
public class ScrumPokerActivity extends Activity
{
	public static String TAG = "SCRUMPOKER";
	public static String SELECTED_POINTS = "POINTS";
	private ListView displayPointsListView;
	private final String[] POINTS =
	{ "?", "0", "\u00BD", "1", "2", "3", "5", "8", "13", "20", "40", "100",
			"\u221E" }; // the unicode is 1/2 and infinity

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		displayPointsListView = (ListView) findViewById(R.id.pointsListView);
		int layoutId = android.R.layout.simple_list_item_1;

		// populate the list view with an array
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				layoutId, POINTS);
		displayPointsListView.setAdapter(arrayAdapter);
		displayPointsListView.setOnItemClickListener(mMessageClickedHandler);
	}

	/** when an item is selected on the list view */
	private final OnItemClickListener mMessageClickedHandler = new OnItemClickListener()
	{
		public void onItemClick(AdapterView parent, View v, int position,
				long id)
		{
			Log.d(TAG, "position : " + position);
			Log.d(TAG, "selection: " + POINTS[position]);

			// create a new intent for the display and add the points value
			Intent displayIntent = new Intent(ScrumPokerActivity.this,
					DisplayActivity.class);
			displayIntent.putExtra(SELECTED_POINTS, POINTS[position]);
			startActivity(displayIntent);
		}
	};
}