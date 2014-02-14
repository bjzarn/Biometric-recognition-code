package com.example.crossfittracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class Shell extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.crossfittracker.MESSAGE";
	public final static String EXTRA_MESSAGE2 = "com.example.crossfittracker.MESSAGE2";

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

	public void sendMessage(View view){
		Intent intent = new Intent (this, Login.class);
		startActivity(intent);
		
	}

}
