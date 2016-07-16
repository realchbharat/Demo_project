package com.example.demo_project;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HistorycodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historycode);
		
		String time = getIntent().getStringExtra("KEY_StringName1");
		
		String s1="http://192.168.0.2:8080/AndroidWebProject/update1?mode=getCode&time="+URLEncoder.encode(time);
		WebRequest req = new WebRequest(s1);
		String code="";
		try {
			code = req.downloadUrl();
		} catch (InterruptedException e1) {
			Toast.makeText(this, e1.getMessage(), 1000).show();
			e1.printStackTrace();
		}
		TextView e= (TextView) findViewById(R.id.text4);
		e.setText(code);
	}

	
}
