package com.example.crossfittracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Shell extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shell_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shell, menu);
		return true;
	}

}
