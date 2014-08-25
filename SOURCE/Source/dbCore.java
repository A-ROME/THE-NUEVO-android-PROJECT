package com.valentine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbCore extends SQLiteOpenHelper {
	
	
	public static final String Table_Userinfo="USER", Table_Confi="CONFIDENTIAL";
   //
	public static final String UserId="Identity", Col_Name="Name",Col_psWord="psWord",ValidationContext="Valid";
   //
	public static final String College="College",Course="Course",RegNo="RegNo";
   //
	public static final String DATABASE_NM="NUEVO.db";
   //
	public static final int DATABASE_VER=2;
	//
	public static final String DATABASE_create="Create table "+Table_Userinfo+" ("+UserId+" integer primary key autoincrement, "+Col_Name+" text not null, "+Col_psWord+" text not null, "+ValidationContext+" text not null); ";
	
	
	
	
	public dbCore(Context context) {
		super(context,DATABASE_NM,null,DATABASE_VER);

	}

	@Override
	public void onCreate(SQLiteDatabase dbVal) {
	dbVal.execSQL(DATABASE_create);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase dbVal, int oldVer, int newVer) {
		Log.w(dbCore.class.getName(),
				"Upgrading database from version " + oldVer + " to "
				+ newVer + ", which will destroy all old data");
				dbVal.execSQL("DROP TABLE IF EXISTS " + Table_Userinfo+";");
				onCreate(dbVal);
		
	}

}
