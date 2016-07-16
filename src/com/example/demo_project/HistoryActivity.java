package com.example.demo_project;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HistoryActivity extends ListActivity {
	String[] History=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WebRequest req = new WebRequest("http://192.168.0.2:8080/AndroidWebProject/update1?mode&time");
		try {
			String ret = req.downloadUrl();
			History = ret.substring(1, ret.length()-2).split(",");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Toast.makeText(this, e.getMessage(), 1000).show();
			
			ListAdapter adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,History);
			setListAdapter(adapter);
		}
		
		
	
		}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, History[position], 1000).show();
		startActivity(new Intent(this,HistorycodeActivity.class).putExtra("KEY_StringName1",History[position]));
	}
}
