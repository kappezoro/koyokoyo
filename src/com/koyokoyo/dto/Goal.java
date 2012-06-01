package com.koyokoyo.dto;

public class Goal {

	/** 目標達成フラグ 未達成 */
	public static final String NON_ACHIEVEMENT = "0";

	/** 目標達成フラグ 達成 */
	public static final String ACHIEVEMENT = "1";

	private Integer goalId;

	private String detail;

	private String goalAchievementFlg;

	public Integer getGoalId() {
		return goalId;
	}

	public void setGoalId(Integer goalId) {
		this.goalId = goalId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getGoalAchievementFlg() {
		return goalAchievementFlg;
	}

	public void setGoalAchievementFlg(String goalAchievementFlg) {
		this.goalAchievementFlg = goalAchievementFlg;
	}

}
