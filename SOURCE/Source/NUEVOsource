package com.valentine;

import android.content.Context;
import android.widget.Toast;

public class SignIn {
 
	
protected String User,Password;	
	
protected CryptoCore crypt;
 private boolean goAhead;
 
 
 Context context;
 


	static final String psword="qwe@123456";
	SignIn(Context context,String user,String password){
		this.context=context;
		this.User=user;
		this.Password=password;
		crypt =	new CryptoCore(context); 
goAhead= validatepassword(password,psword);
		
	}
	
	private boolean validatepassword(String password, String psword2) {
	final String Validationcont=crypt.Decrypt(password, crypt.Encrypt(password,psword));
		if(password==Validationcont){
			return true;
		}else{
			
			
		return	networkValidate(this.User,this.Password);}
	}

	
	
	private boolean networkValidate(String user2, String password2) {
		
		return false;
	}

	public boolean getGoAhead(){
		
		return goAhead;
		
	}

}
