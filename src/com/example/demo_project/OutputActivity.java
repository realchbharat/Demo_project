package com.example.demo_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OutputActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);
		
		TextView t= (TextView) findViewById(R.id.text2);
		String s=t.getText().toString();
		t.setText(s+getIntent().getStringExtra("KEY_StringName"));
	}

}
