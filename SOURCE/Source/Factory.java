package com.valentine;

import android.database.SQLException;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;

public class Factory {
	
	//Objects and DataSources 
	private Valentine valentine;
    private UserDataSource data;
   
    
    
    
 
	
	
 public Factory(Valentine valentine) {
	this.valentine=valentine;
	data=new UserDataSource(this.valentine);
	try{
	data.open();
	}catch(SQLException e){
		Toast toast = Toast.makeText(valentine.getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG );
		toast.show();
		
		
	}
	}

//checks database for user information and returns the goAhead truth.
public  void requestGoAhead(){

 }

















//ALL THATS STATIC

public static void expand(final View v) {
    v.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    final int targtetHeight = v.getMeasuredHeight();

    v.getLayoutParams().height = 0;
    v.setVisibility(View.VISIBLE);
    Animation a = new Animation()
    {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
        	
            v.getLayoutParams().height = interpolatedTime == 1
                    ? LayoutParams.WRAP_CONTENT
                    : (int)(targtetHeight * interpolatedTime);
            v.requestLayout();
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    };

  
    a.setDuration(1000);
    a.setStartOffset(2000);
  
    v.startAnimation(a);
}

public static void collapse(final View v) {
    final int initialHeight = v.getMeasuredHeight();

    Animation a = new Animation()
    {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            if(interpolatedTime == 1){
                v.setVisibility(View.GONE);
            }else{
                v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                v.requestLayout();
            }
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    };

    a.setDuration(1000);
    a.setStartOffset(2000);
    v.startAnimation(a);
}


public static void fadein(final View v){
	
	 
	Animation animation1 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, 0.0f,
            Animation.RELATIVE_TO_PARENT, 0.0f,
            Animation.RELATIVE_TO_PARENT, +1.0f,
            Animation.RELATIVE_TO_PARENT, 0.0f);
    
    animation1.setInterpolator(new AccelerateInterpolator());
    animation1.setDuration(1000);
    animation1.setStartOffset(2000);
  v.startAnimation(animation1);



}




}
