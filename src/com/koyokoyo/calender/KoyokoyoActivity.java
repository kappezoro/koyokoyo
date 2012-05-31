package com.koyokoyo.calender;


import java.util.ArrayList;
import java.util.Calendar;

import com.koyokoyo.calender.R.id;
import com.koyokoyo.calender.logic.CalendarLogic;
import com.koyokoyo.calender.service.SwitchValueService;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class KoyokoyoActivity extends Activity {

	Bundle savedInstanceState;
	SwitchValueService switchValueService;
	int monthCount = 0;
	int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	int yearCount = 0;
	String monthName = null;
	
	public class BindData {  
        int iconId;  
        String title;  
    
        BindData(int id, String s) {  
            this.iconId = id;  
            this.title = s;  
        }  
    }  

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SwitchValueService switchValueService = new SwitchValueService();

		CalendarLogic monthlyCalendar = new CalendarLogic(currentYear
				+ yearCount, month + monthCount);
		final ArrayList<String> dateList = monthlyCalendar.calcFields();

		TextView titleView = (TextView) findViewById(id.title);
		TextView yearView = (TextView) findViewById(id.year);
		TextView monthView = (TextView) findViewById(id.currentMonth);
		TextView upView = (TextView) findViewById(id.up);
		TextView downView = (TextView) findViewById(id.down);
		TextView monView = (TextView) findViewById(id.mon);
		TextView tueView = (TextView) findViewById(id.tue);
		TextView wedView = (TextView) findViewById(id.wed);
		TextView thuView = (TextView) findViewById(id.thu);
		TextView friView = (TextView) findViewById(id.fri);
		TextView satView = (TextView) findViewById(id.sat);
		TextView sunView = (TextView) findViewById(id.sun);

		titleView.setText(R.string.title);
		upView.setText(R.string.up);
		downView.setText(R.string.down);
		monthName = switchValueService.monthSwitch(month, monthCount);

		yearView.append(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR) + yearCount));
		monthView.append(monthName);

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
		gridViewDate.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				view.setClickable(true);
			    view.setBackgroundDrawable(getResources().getDrawable(R.drawable.hanamaru));
			    
			}
		});
	}

	public void onClickButtonUp(View view) {
		SwitchValueService switchValueService = new SwitchValueService();
		monthCount++;
		switchValueService.monthSwitch(month, monthCount);
		if (month + monthCount > 12) {
			yearCount++;
			month = 1;
			monthCount = 0;
		}
		onCreate(savedInstanceState);
		Log.i("Next", String.valueOf(monthCount));
	}

	public void onClickButtonDown(View view) {
		SwitchValueService switchValueService = new SwitchValueService();
		monthCount--;
		switchValueService.monthSwitch(month, monthCount);
		if (month + monthCount < 1) {
			yearCount--;
			month = 12;
			monthCount = 0;
		}
		onCreate(savedInstanceState);
		Log.i("Previous", String.valueOf(monthCount));
	}

}
