package com.koyokoyo.calender;

import java.util.Calendar;

import org.junit.Test;

public class KoyokoyoActivityTest {
	
	@Test
	public void canDisplayDate(){
	Calendar calendar = Calendar.getInstance();
	 int year = calendar.get(Calendar.YEAR);
     int month = calendar.get(Calendar.MONTH);
     int day = calendar.get(Calendar.DAY_OF_MONTH);
     int dayOfWeek =calendar.get(Calendar.DAY_OF_WEEK);
     
     System.out.println("year="+year +" ,month="+month+", day="+day+", "+"dayOfWeek="+dayOfWeek );
		
	}
	

}
