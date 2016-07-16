package com.example.demo_project;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		String[] languages = { "java" , "c++" , "python" , "ruby" };
		ListAdapter bharatsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, languages);
		ListView bharatsListView = (ListView) findViewById(R.id.text2);
		bharatsListView.setAdapter(bharatsAdapter);

		bharatsListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
						String food = String.valueOf(parent.getItemAtPosition(position));
						
						//Toast.makeText(HomeActivity.this, food, 1000).show();
						
						startActivity(new Intent(HomeActivity.this,TexteditorActivity.class));
						
						
					}

				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id == R.id.action_history){
			startActivity(new Intent(this,HistoryActivity.class));
		}
		return super.onOptionsItemSelected(item);

	}

}