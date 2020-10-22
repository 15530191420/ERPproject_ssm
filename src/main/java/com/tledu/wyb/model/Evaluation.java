package com.tledu.wyb.model;

public class Evaluation {
	private int id;
	private String theme;
	private String circleSort;
	private String checkCircle;
	private String startDate;
	private String endDate;
	private String creatDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getCircleSort() {
		return circleSort;
	}
	public void setCircleSort(String circleSort) {
		this.circleSort = circleSort;
	}
	public String getCheckCircle() {
		return checkCircle;
	}
	public void setCheckCircle(String checkCircle) {
		this.checkCircle = checkCircle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public Evaluation(String theme, String circleSort, String checkCircle,
			String startDate, String endDate, String creatDate) {
		super();
		this.theme = theme;
		this.circleSort = circleSort;
		this.checkCircle = checkCircle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creatDate = creatDate;
	}
	public Evaluation(int id, String theme, String circleSort,
			String checkCircle, String startDate, String endDate,
			String creatDate) {
		super();
		this.id = id;
		this.theme = theme;
		this.circleSort = circleSort;
		this.checkCircle = checkCircle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creatDate = creatDate;
	}
	public Evaluation(int id) {
		super();
		this.id = id;
	}
	
}
