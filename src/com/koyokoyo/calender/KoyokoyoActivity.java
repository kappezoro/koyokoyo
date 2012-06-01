package com.koyokoyo.calender;


import java.util.ArrayList;

import java.util.Calendar;

import com.koyokoyo.calender.R.id;
import com.koyokoyo.calender.logic.CalendarLogic;
import com.koyokoyo.calender.service.SwitchValueService;
import com.koyokoyo.dto.Goal;
import com.koyokoyo.util.DBAdapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
	
	final DBAdapter dbAdapter = new DBAdapter(KoyokoyoActivity.this);

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
		initializedGoal();
		findViewById(R.id.newButton).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater li = LayoutInflater.from(v.getContext());
				final View goalView = li.inflate(R.layout.registrant_goal_view, null);

				new AlertDialog.Builder(v.getContext())
						.setCancelable(true)
						.setPositiveButton("ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText et = (EditText)goalView.findViewById(R.id.input_goal);
								Goal goalDto = new Goal();
								goalDto.setDetail(et.getText().toString());
								goalDto.setGoalAchievementFlg(Goal.NON_ACHIEVEMENT);
								dbAdapter.open();
								dbAdapter.insertGoal(goalDto);
								dbAdapter.close();
								TextView tv = (TextView)findViewById(R.id.goal);
								tv.setText(goalDto.getDetail());
							}
						})
						.setNegativeButton("キャンセル", null)
						.setView(goalView)
						.show();
			}
		});

		
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
	
	/**
	 * 目標部分の初期化
	 */
	private void initializedGoal() {
		TextView goal = (TextView)findViewById(R.id.goal);
		dbAdapter.open();
		goal.setText(dbAdapter.getLatestGoal());
		dbAdapter.close();
	}

}
