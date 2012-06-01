package com.koyokoyo.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.koyokoyo.dto.Goal;

/**
 * データベース処理を行うクラスです。
 *
 * @author Yuka Takahashi
 *
 */
public class DBAdapter {

	/** データベース名 */
	final String DB_NAME = "koyokoyo_db";

	/** データベースバージョン */
	final int DB_VERSION = 1;

	/** データベース */
	SQLiteDatabase db;

	/** DBヘルパー */
	DBHelper helper;

	public DBAdapter(Context context) {
		helper = new DBHelper(context);
	}

	/**
	 * DBヘルパークラスです。
	 *
	 * @author Yuka Takahashi
	 *
	 */
	private class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table goal( "
					+ "goal_id integer primary key autoincrement,"
					+ "detail text not null,"
					+ "goal_achievement_flg text not null DEFAULT '0'"
					+" );"
				);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}

	/**
	 * データベースをオープンします。
	 */
	public void open() {
		db = helper.getWritableDatabase();
	}

	/**
	 * データベースをクローズします。
	 */
	public void close() {
		if (db != null)
			db.close();
		if (helper != null)
			helper.close();
	}

	/**
	 * 目標を登録します。
	 *
	 * @return 成功した場合 {@code true} <br>
	 *         失敗した場合 {@code false}
	 */
	public boolean insertGoal(Goal goal) {
		db.beginTransaction();
		try {
			ContentValues val = new ContentValues();
			val.put("detail", goal.getDetail());
			val.put("goal_achievement_flg", goal.getGoalAchievementFlg());
			long resultRowId = db.insert("goal", null, val);

			db.setTransactionSuccessful();
			return resultRowId != -1;
		} catch (Exception e) {
			Log.e("ERROR", "目標登録時にエラーが発生しました。");
		} finally {
			db.endTransaction();
		}
		return false;
	}

	/**
	 * 最新の目標を取得します。
	 *
	 * @return 最新の目標
	 */
	public String getLatestGoal() {
		String colums[] = {"detail"};

		Cursor cursor = db.query("goal", colums, null, null, null, null, "goal_id");
		if (cursor.getCount() != 0) {
			cursor.moveToLast();
			return cursor.getString(0);
		}
		return null;
	}

}
