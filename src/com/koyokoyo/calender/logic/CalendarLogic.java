package com.koyokoyo.calender.logic;

import java.util.ArrayList;
import java.util.Calendar;

import android.util.Log;

public class CalendarLogic {

	private int year;
	private int month;
	private int[][] calendarMatrix = new int[6][7];
	private int startDay;
	private int lastDate;
	private int date=1;

	/**
	 * カレンダー表オブジェクトを作成します。
	 * 
	 * @param year
	 *            西暦年(..., 2005, 2006, 2007, ...)
	 * @param month
	 *            月(1, 2, 3, ..., 10, 11, 12)
	 */
	public CalendarLogic(int year, int month) {
		this.year = year;
		this.month = month;
	}

	public ArrayList<String> calcFields() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month - 1, date);
		startDay = calendar.get(Calendar.DAY_OF_WEEK);
		Log.v("youbi", String.valueOf(calendar.getFirstDayOfWeek()));

		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		lastDate = calendar.get(Calendar.DATE);
		int row = 0;
		int column = startDay - 1;
		ArrayList<String> list = new ArrayList<String>();
		int start = startDay;
		while (start > 1) {
			list.add("");
			start--;
		}

		for (int date = 1; date <= lastDate; date++) {
			calendar.set(year, month, date);

			calendarMatrix[row][column] = date;
			list.add(String.valueOf(date));
		}
		return list;
	}
	
	
}
