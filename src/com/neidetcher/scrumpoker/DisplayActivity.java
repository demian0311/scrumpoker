package com.neidetcher.scrumpoker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Simply display the text that was selected.
 */
public class DisplayActivity extends Activity
{
	TextView myTextView = null;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);

		// set value for the text
		myTextView = (TextView) findViewById(R.id.displayPointsTextView);
		String points = getIntent().getExtras().getString(
				ScrumPokerActivity.SELECTED_POINTS);
		if (points.equals("100"))
		{
			myTextView.setTextSize(180);
		}

		myTextView.setText(points);
	}
}