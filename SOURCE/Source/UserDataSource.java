package com.valentine;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
   
	
	private SQLiteDatabase database;
	private dbCore Core;
	private String[] User_Columns = {dbCore.Col_Name,dbCore.ValidationContext,dbCore.Col_psWord};
	private String User=null;
	private String Vcontext=null,Cpassword=null;
	
	private Context context;
	
	
	public UserDataSource(Context context){
		this.context=context;
		Core=new dbCore(context);
		}
	
	
		
		
	
	
	
public void open()throws SQLException{
	database= Core.getWritableDatabase();
	Cursor curs=database.query(dbCore.Table_Userinfo, User_Columns, null, null, null, null,null);
	curs.moveToFirst();
	while(!curs.isAfterLast()){
	User=curs.getString(0);
	Vcontext=curs.getString(1);Cpassword=curs.getString(2);
	}
	curs.close();
}


public void close(){
	Core.close();
}








public Context wantCont(){
	
	return context;
}
	
}
