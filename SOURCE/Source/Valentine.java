package com.valentine;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


public class Valentine extends Activity {
	
	//Factory as resources for instructions
	private Factory factory;
	public View mContentView;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		factory=new Factory(this);
		
	factory.requestGoAhead();
		
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
			
		setContentView(R.layout.activity_valentine);
		 mContentView = findViewById(R.id.content);
		 mContentView.setVisibility(View.VISIBLE);
		
		 Typeface tf= Typeface.createFromAsset(this.getAssets(),"fonts/BodoniFLF-Roman.ttf");
         TextView tv=(TextView)findViewById(R.id.identity);
         tv.setTypeface(tf);
         Factory.expand(mContentView);
         findViewById(R.id.login).setOnClickListener(new OnClickListener(){
        	
        
			@Override
			public void onClick(View v) {
			if(goAhead()){
				Factory.collapse(mContentView);
				
			}
				
			} 
         });
         
		
	}
	@Override
 public void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
	   
		
	
		
	}
	
	
private boolean goAhead(){
	EditText use=(EditText)findViewById(R.id.user);
	String user=use.getText().toString();
	use=(EditText)findViewById(R.id.password);
	String password=use.getText().toString();
	return new SignIn(getApplicationContext(),user,password).getGoAhead();
}
	

	
	

	

}
