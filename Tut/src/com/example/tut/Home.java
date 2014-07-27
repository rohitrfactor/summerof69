package com.example.tut;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.os.Build;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		/*if(Build.VERSION.SDK_INT<16){
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			ActionBar actionBar = getActionBar();
			actionBar.hide();
		}
		else {
			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
			ActionBar actionBar = getActionBar();
			actionBar.hide();
		}*/
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				
				SharedPreferences myPrefs = Home.this.getSharedPreferences("contact", MODE_WORLD_READABLE);
			    String gor = myPrefs.getString("sample", "com.example.tut.MainActivity");
			    
			    
			    try {
		            
		      	  

		      	  Intent intent1 = new Intent( Home.this, Class.forName( gor ) );
		      	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		      	  startActivity(intent1);

		      	} catch (ClassNotFoundException e1) {

		      	  e1.printStackTrace();  

		      	} 
				
			}
		},2000 );
		
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
