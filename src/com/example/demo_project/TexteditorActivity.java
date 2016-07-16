package com.example.demo_project;

import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TexteditorActivity extends Activity {
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_texteditor);
		
		/*String time = getIntent().getStringExtra("KEY_StringName1");
		if(time.trim().length()<2)return;
		String s1="http://192.168.1.166:8080/AndroidWebProject/update1?mode=getCode&time="+URLEncoder.encode(time);
		WebRequest req = new WebRequest(s1);
		String code="";
		try {
			code = req.downloadUrl();
		} catch (InterruptedException e1) {
			Toast.makeText(this, e1.getMessage(), 1000).show();
			e1.printStackTrace();
		}
		EditText e= (EditText) findViewById(R.id.edit1);
		e.setText(code);*/
		
	}
	
	public void run(View v) throws InterruptedException
	{
		EditText e= (EditText) findViewById(R.id.edit1);
		String s1=e.getText().toString();
		//String s1="public+class+A%7Bpublic+static+void+main%28String%5B%5D+args%29+throws+Exception%7BSystem.out.println%28123%29%3B%7D%7D";
		s1=URLEncoder.encode(s1);
		//provide languange info as well
		WebRequest req = new WebRequest("http://192.168.0.2:8080/AndroidWebProject/updateFan?javacode="+s1);
		String dbPwd = req.downloadUrl();
		Toast.makeText(this, dbPwd, 1000).show();
		
		
		startActivity(new Intent(TexteditorActivity.this, OutputActivity.class).putExtra("KEY_StringName",dbPwd));
		
		
		
		//startActivity(new Intent(this,OutputActivity.class));
		//TextView t= (TextView) findViewById(R.id.text2);
		//t.setText(dbPwd);
		
		
	}
}
