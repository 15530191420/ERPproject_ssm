package com.tledu.wyb.model;

public class Leave {
	private int id;
	private String leavename;
	private String startDate;
	private String belongDept;
	private String post;
	private String arrivalDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLeavename() {
		return leavename;
	}
	public void setLeavename(String leavename) {
		this.leavename = leavename;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getBelongDept() {
		return belongDept;
	}
	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leave(int id, String leavename, String startDate, String belongDept,
			String post, String arrivalDate) {
		super();
		this.id = id;
		this.leavename = leavename;
		this.startDate = startDate;
		this.belongDept = belongDept;
		this.post = post;
		this.arrivalDate = arrivalDate;
	}
	public Leave(String leavename, String startDate, String belongDept,
			String post, String arrivalDate) {
		super();
		this.leavename = leavename;
		this.startDate = startDate;
		this.belongDept = belongDept;
		this.post = post;
		this.arrivalDate = arrivalDate;
	}
	public Leave(int id) {
		super();
		this.id = id;
	}
	
}
