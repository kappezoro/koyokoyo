package com.koyokoyo.calender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "koyokoyo", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("test1");
		db.execSQL(
				"create table target( " +
				"_id integer primary key autoincrement," +
				"target_value text not null" +
				" );"
			);

		System.out.println("test");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
