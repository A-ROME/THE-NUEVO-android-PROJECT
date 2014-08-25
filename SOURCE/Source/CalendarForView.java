package com.valentine;

import java.util.Calendar;
import java.util.Date;

public class CalendarForView {

 private Date date;
 private Calendar calendar;	
 CalendarForView(){
	
	 calendar=Calendar.getInstance();
	 date=calendar.getTime();
 }
	
}
