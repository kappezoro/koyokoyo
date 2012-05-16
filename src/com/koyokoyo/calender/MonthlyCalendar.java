package com.koyokoyo.calender;

import java.util.ArrayList;
import java.util.Calendar;

public class MonthlyCalendar {

	private int year;

	private int month;

	private int[][] calendarMatrix = new int[6][7];

	private int startDay;

	private int lastDate;

	/**
	 * カレンダー表オブジェクトを作成します。
	 * 
	 * @param year
	 *            西暦年(..., 2005, 2006, 2007, ...)
	 * @param month
	 *            月(1, 2, 3, ..., 10, 11, 12)
	 */
	public MonthlyCalendar(int year, int month) {
		this.year = year;
		this.month = month;
	}

	public ArrayList<String> calcFields() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		// 月の初めの曜日を求めます。
		calendar.set(year, month - 1, 1); // 引数: 1月: 0, 2月: 1, ...
		startDay = calendar.get(Calendar.DAY_OF_WEEK);
		// 月末の日付を求めます。
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		lastDate = calendar.get(Calendar.DATE);
		// カレンダー表を作成します。
		int row = 0;
		int column = startDay - 1; // startDay: 日曜日 = 1, 月曜日 = 2, ...
		ArrayList<String> list = new ArrayList<String>();
		int start =3;
		while(start!= calendar.get(Calendar.DAY_OF_WEEK)){
			list.add("");
			start++;
		}

		for (int date = 1; date <= lastDate; date++) {
	
				calendarMatrix[row][column] = date;
				list.add(String.valueOf(date));
			}
		return list;
	}
}

// public static void main(String[] args) {
// int currentYear = Calendar.getInstance().get(Calendar.YEAR);
// for (int month = 1; month <= 12; month++) {
// System.out.println(currentYear + "年" + month + "月");
// System.out.println(new MonthlyCalendar(currentYear, month));
// }
// }
