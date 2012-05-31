package com.koyokoyo.calender.service;


public class SwitchValueService {
	
	public String monthSwitch(int month, int monthCount) {
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
