package com.valentine;

public class UserInfo {
	
	//
	private long UserId;
	private String Name,psWord,Email;
	
	//
	public String getName(){
		
		return Name;
		
	}
	 public void setName(String Name){
		 
		 this.Name=Name;
	 }
	
	// 
	public long getUserId(){
		
		return UserId;
		}
	
	//
	public void setUserId(long UserId){
		
		this.UserId=UserId;
	}
	
//
	public String getpsWord(){
		
		return psWord;
	}
   
	//
	public void setpsWord(String psWord){
		
		this.psWord=psWord;
		}
	
	//
	public String getEmail(){
		
		return Email;
		}
	
	//
	public void setEmail(String Email){
		
		this.Email=Email;
	}
	
	
}
