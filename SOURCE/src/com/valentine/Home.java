package com.valentine;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 if (Build.VERSION.SDK_INT < 16) {
	            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        }else{
	        	View decorView = getWindow().getDecorView();
	        	// Hide the status bar.
	        	int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
	        	decorView.setSystemUiVisibility(uiOptions);
	        	// Remember that you should never show the action bar if the
	        	// status bar is hidden, so hide that too if necessary.
	        	ActionBar actionBar = getActionBar();
	        	actionBar.hide();
	        }
		 
		setContentView(R.layout.home);
		setFonts();
	}


protected void setFonts(){
	TextView tv=(TextView)fingViewById(R.id.Home);
	
}
	
}
