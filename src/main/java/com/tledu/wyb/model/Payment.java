package com.tledu.wyb.model;

public class Payment {
	private int id;
	private String theme;
	private String month;
	private String startDate;
	private String endDate;
	private String editor;
	private String editorDate;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getEditorDate() {
		return editorDate;
	}
	public void setEditorDate(String editorDate) {
		this.editorDate = editorDate;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int id, String theme, String month, String startDate,
			String endDate, String editor, String editorDate) {
		super();
		this.id = id;
		this.theme = theme;
		this.month = month;
		this.startDate = startDate;
		this.endDate = endDate;
		this.editor = editor;
		this.editorDate = editorDate;
	}
	public Payment(String theme, String month, String startDate,
			String endDate, String editor, String editorDate) {
		super();
		this.theme = theme;
		this.month = month;
		this.startDate = startDate;
		this.endDate = endDate;
		this.editor = editor;
		this.editorDate = editorDate;
	}
	public Payment(int id) {
		super();
		this.id = id;
	}
	
}
