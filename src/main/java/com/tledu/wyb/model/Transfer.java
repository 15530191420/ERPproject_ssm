package com.tledu.wyb.model;

public class Transfer {
	//编号
	private int id;
	//申请人
	private String applyname;
	//申请时间
	private String applyDate;
	//目前部门
	private String currentDept;
	//目前岗位
	private String currentPosition;
	//目前级别
	private String currentLevel;
	//希望日期
	private String hopeDate;
	//调至部门
	private String targetDept;
	//调至岗位
	private String tatgetPosition;
	//调至级别
	private String targetLevel;
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApplyname() {
		return applyname;
	}
	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getCurrentDept() {
		return currentDept;
	}
	public void setCurrentDept(String currentDept) {
		this.currentDept = currentDept;
	}
	public String getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	public String getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}
	public String getHopeDate() {
		return hopeDate;
	}
	public void setHopeDate(String hopeDate) {
		this.hopeDate = hopeDate;
	}
	public String getTargetDept() {
		return targetDept;
	}
	public void setTargetDept(String targetDept) {
		this.targetDept = targetDept;
	}
	public String getTatgetPosition() {
		return tatgetPosition;
	}
	public void setTatgetPosition(String tatgetPosition) {
		this.tatgetPosition = tatgetPosition;
	}
	public String getTargetLevel() {
		return targetLevel;
	}
	public void setTargetLevel(String targetLevel) {
		this.targetLevel = targetLevel;
	}
	public Transfer(int id, String applyname, String applyDate,
			String currentDept, String currentPosition, String currentLevel,
			String hopeDate, String targetDept, String tatgetPosition,
			String targetLevel) {
		super();
		this.id = id;
		this.applyname = applyname;
		this.applyDate = applyDate;
		this.currentDept = currentDept;
		this.currentPosition = currentPosition;
		this.currentLevel = currentLevel;
		this.hopeDate = hopeDate;
		this.targetDept = targetDept;
		this.tatgetPosition = tatgetPosition;
		this.targetLevel = targetLevel;
	}
	public Transfer(int id) {
		super();
		this.id = id;
	}
	public Transfer(String applyname, String applyDate, String currentDept,
			String currentPosition, String currentLevel, String hopeDate,
			String targetDept, String tatgetPosition, String targetLevel) {
		super();
		this.applyname = applyname;
		this.applyDate = applyDate;
		this.currentDept = currentDept;
		this.currentPosition = currentPosition;
		this.currentLevel = currentLevel;
		this.hopeDate = hopeDate;
		this.targetDept = targetDept;
		this.tatgetPosition = tatgetPosition;
		this.targetLevel = targetLevel;
	}
	
	
}
