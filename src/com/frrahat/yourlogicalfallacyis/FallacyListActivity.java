package com.frrahat.yourlogicalfallacyis;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FallacyListActivity extends Activity {

	private ListView listViewFallacies;
	private BaseAdapter baseAdapter;
	private ArrayList<Fallacy> fallacies;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fallacy_list);
		
		FallacyContainer.loadList(this);
		fallacies=FallacyContainer.getList();
		
		listViewFallacies=(ListView) findViewById(R.id.listViewFallacies);		
		final LayoutInflater layoutInflater = getLayoutInflater();
		
		baseAdapter=new BaseAdapter() {
			@Override
			public View getView(int position, View view, ViewGroup parent) {
				if (view == null) {
					view = layoutInflater.inflate(
							R.layout.list_item, null);
				}
				ImageView imgView = (ImageView) view
						.findViewById(R.id.imageViewIcon);
				TextView textView = (TextView) view
						.findViewById(R.id.textItemName);
				
				Fallacy fallacy=fallacies.get(position);
				
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					imgView.setImageDrawable(getResources().getDrawable(getResources()
			                  .getIdentifier(fallacy.getIconFileString(), "drawable", getPackageName()), getTheme()));
				}else{
					//Log.i("a", fallacy.getName());
					imgView.setImageDrawable(getResources().getDrawable(getResources()
			                  .getIdentifier(fallacy.getIconFileString(), "drawable", getPackageName())));
				}
				
				textView.setText(fallacy.getName());
				
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return position;
			}
			
			@Override
			public int getCount() {
				return fallacies.size();
			}
		};
		
		listViewFallacies.setAdapter(baseAdapter);
		listViewFallacies.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Intent intent=new Intent(FallacyListActivity.this, ShowFallacyActivity.class);
				intent.putExtra("pos", position);
				
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fallacy_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
