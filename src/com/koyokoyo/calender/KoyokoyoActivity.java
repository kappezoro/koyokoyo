package com.koyokoyo.calender;

import java.util.ArrayList;

import java.util.Calendar;
import com.koyokoyo.calender.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class KoyokoyoActivity extends Activity {
	/** Called when the activity is first created. */

	/*
	 * Sun:1, Mon:2,Tue:3,Wed:4,Thu:5,
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH)+1;
		MonthlyCalendar monthlyCalendar = new MonthlyCalendar(currentYear,
				month);
		ArrayList<String> dayOfTheWeekList = new ArrayList<String>();
		ArrayList<String> dateList = monthlyCalendar.calcFields();

		dayOfTheWeekList.add("日");
		dayOfTheWeekList.add("月");
		dayOfTheWeekList.add("火");
		dayOfTheWeekList.add("水");
		dayOfTheWeekList.add("木");
		dayOfTheWeekList.add("金");
		dayOfTheWeekList.add("土");


		TextView titleView = (TextView) findViewById(id.title);
		TextView yearView = (TextView) findViewById(id.year);
		TextView monthView = (TextView) findViewById(id.month);
		// テキストビューのテキストを設定します
		titleView.setText(R.string.title);
	
		String monthName = null;
		switch(Calendar.getInstance().get(Calendar.MONTH)+1){
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "Feburuary";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		}

		yearView.append(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		monthView.append(monthName);

		ArrayAdapter<String> dayOfTheWeekAdapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				dayOfTheWeekList);

		GridView gridViewDayOfTheWeek = (GridView) findViewById(R.id.dayOfTheWeek);
		gridViewDayOfTheWeek.setAdapter(dayOfTheWeekAdapter);

		ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				dateList);

		GridView gridViewDate = (GridView) findViewById(R.id.date);
		gridViewDate.setAdapter(dateAdapter);
	}
}
