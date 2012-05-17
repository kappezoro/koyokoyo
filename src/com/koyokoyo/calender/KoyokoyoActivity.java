package com.koyokoyo.calender;

import java.util.ArrayList;

import java.util.Calendar;
import com.koyokoyo.calender.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
	Bundle savedInstanceState;

	int monthCount = 0;
	int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	int yearCount =0;
	String monthName = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		MonthlyCalendar monthlyCalendar = new MonthlyCalendar(currentYear+yearCount,
				month+monthCount);
		ArrayList<String> dateList = monthlyCalendar.calcFields();

		TextView titleView = (TextView) findViewById(id.title);
		TextView yearView = (TextView) findViewById(id.year);
		TextView monthView = (TextView) findViewById(id.currentMonth);
		TextView upView = (TextView) findViewById(id.up);
		TextView downView = (TextView) findViewById(id.down);
		titleView.setText(R.string.title);
		upView.setText(R.string.up);
		downView.setText(R.string.down);

		monthName = monthSwitch(monthCount);

		yearView.append(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)+yearCount));
		monthView.append(monthName);

		TextView monView = (TextView) findViewById(id.mon);
		TextView tueView = (TextView) findViewById(id.tue);
		TextView wedView = (TextView) findViewById(id.wed);
		TextView thuView = (TextView) findViewById(id.thu);
		TextView friView = (TextView) findViewById(id.fri);
		TextView satView = (TextView) findViewById(id.sat);
		TextView sunView = (TextView) findViewById(id.sun);

		monView.setText(R.string.mon);
		tueView.setText(R.string.tue);
		wedView.setText(R.string.wed);
		thuView.setText(R.string.thu);
		friView.setText(R.string.fri);
		satView.setText(R.string.sat);
		sunView.setText(R.string.sun);

		ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				dateList);

		GridView gridViewDate = (GridView) findViewById(R.id.date);
		gridViewDate.setAdapter(dateAdapter);
	}

	public void onClickButtonUp(View view) {
		monthCount++;
		monthSwitch(monthCount);
		if (month + monthCount > 12) {
			yearCount++;
			month = 1;
			monthCount = 0;
		}
		onCreate(savedInstanceState);
		Log.i("Next", String.valueOf(monthCount));
	}

	public void onClickButtonDown(View view) {
		monthCount--;
		monthSwitch(monthCount);
		if (month + monthCount < 1) {
			yearCount--;
			month = 12;
			monthCount = 0;
		}
		onCreate(savedInstanceState);
		Log.i("Previous", String.valueOf(monthCount));
	}

	private String monthSwitch(int monthCount) {
		String monthName = null;
		switch (month + monthCount) {
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
		return monthName;
	}

}
