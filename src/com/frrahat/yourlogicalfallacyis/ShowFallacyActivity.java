package com.frrahat.yourlogicalfallacyis;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowFallacyActivity extends Activity {
	
	private ImageView imgView;
	private TextView txtViewName;
	private TextView txtViewDefinition;
	private TextView txtViewSource;
	private TextView txtViewExample;
	private EditText editTextNote;
	
	private int pos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_fallacy);
		
		imgView=(ImageView) findViewById(R.id.imageViewHeader);
		txtViewName=(TextView) findViewById(R.id.textViewName);
		txtViewDefinition=(TextView) findViewById(R.id.textViewDefinition);
		txtViewSource=(TextView) findViewById(R.id.textViewSource);
		txtViewExample=(TextView) findViewById(R.id.textViewExample);
		
		editTextNote=(EditText) findViewById(R.id.editTextNote);
		
		pos=getIntent().getIntExtra("pos", 0);
		
		updateTexts();
	}

	private void updateTexts() {
		Fallacy fallacy=FallacyContainer.getItemAt(pos);
		if(fallacy==null)
			return;
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			imgView.setImageDrawable(getResources().getDrawable(getResources()
	                  .getIdentifier(fallacy.getIconFileString(), "drawable", getPackageName()), getTheme()));
		}else{
			imgView.setImageDrawable(getResources().getDrawable(getResources()
	                  .getIdentifier(fallacy.getIconFileString(), "drawable", getPackageName())));
		}
		txtViewName.setText(fallacy.getName());
		txtViewDefinition.setText(fallacy.getDefinition());
		txtViewSource.setText(fallacy.getSource());
		txtViewExample.setText(fallacy.getExample());
		
		if(fallacy.getNote()==null){
			editTextNote.setVisibility(View.GONE);
		}
		else{
			editTextNote.setText(fallacy.getNote());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_fallacy, menu);
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
