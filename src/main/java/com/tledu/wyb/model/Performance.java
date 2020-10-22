package com.tledu.wyb.model;

public class Performance {
	private int id;
	private String progTheme;
	private String creater;
	private String createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProgTheme() {
		return progTheme;
	}
	public void setProgTheme(String progTheme) {
		this.progTheme = progTheme;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Performance(int id, String progTheme, String creater,
			String createDate) {
		super();
		this.id = id;
		this.progTheme = progTheme;
		this.creater = creater;
		this.createDate = createDate;
	}
	public Performance(String progTheme, String creater, String createDate) {
		super();
		this.progTheme = progTheme;
		this.creater = creater;
		this.createDate = createDate;
	}
	public Performance(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "performance [id=" + id + ", progTheme=" + progTheme
				+ ", creater=" + creater + ", createDate=" + createDate + "]";
	}
	
}
