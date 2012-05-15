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
		//int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int month =1;
		MonthlyCalendar monthlyCalendar = new MonthlyCalendar(currentYear, month);
		ArrayList<Integer> list =monthlyCalendar.calcFields();
		//Calendar calendar =Calendar.getInstance();
	    //for (month = 1; month <= 12; month++) {
			//Log.e("かれんだー", currentYear + "年" + currentMonth + "月");
			//Log.e("かれんだー", monthlyCalendar.toString());
	    	//list.add( currentMonth + "月");
	    	//list.add("日");
			//list.add("月");
			//list.add("火");
			//list.add("水");
			//list.add("木");
			//list.add("金");
			//list.add("土");
			
			//while(Calender.DATE)
	    	//list.add(String.valueOf(Calendar.DATE));
	   // }

		TextView titleView = (TextView) findViewById(id.title);
		TextView yearView = (TextView) findViewById(id.year);
		TextView monthView = (TextView) findViewById(id.month);
		// テキストビューのテキストを設定します
		titleView.setText(R.string.title);
		// yearView.setText(R.string.year);
		// monthView.setText(R.string.month);

		yearView.setText(R.string.year);
		monthView.setText(R.string.month);

		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				list);

		GridView gridView = (GridView) findViewById(R.id.View1);
		gridView.setAdapter(adapter);
	}
}
