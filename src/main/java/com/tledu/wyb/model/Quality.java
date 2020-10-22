package com.tledu.wyb.model;

public class Quality {
	private int id;
	private String qualityTheme;
	private String originalType;
	private String currentUnits;
	private String categ;
	private String inspectionMethods;
	private String inspectionPersonnel;
	private String inspectionDept;
	private String inspectionDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQualityTheme() {
		return qualityTheme;
	}
	public void setQualityTheme(String qualityTheme) {
		this.qualityTheme = qualityTheme;
	}
	public String getOriginalType() {
		return originalType;
	}
	public void setOriginalType(String originalType) {
		this.originalType = originalType;
	}
	public String getCurrentUnits() {
		return currentUnits;
	}
	public void setCurrentUnits(String currentUnits) {
		this.currentUnits = currentUnits;
	}
	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	public String getInspectionMethods() {
		return inspectionMethods;
	}
	public void setInspectionMethods(String inspectionMethods) {
		this.inspectionMethods = inspectionMethods;
	}
	public String getInspectionPersonnel() {
		return inspectionPersonnel;
	}
	public void setInspectionPersonnel(String inspectionPersonnel) {
		this.inspectionPersonnel = inspectionPersonnel;
	}
	public String getInspectionDept() {
		return inspectionDept;
	}
	public void setInspectionDept(String inspectionDept) {
		this.inspectionDept = inspectionDept;
	}
	public String getInspectionDate() {
		return inspectionDate;
	}
	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	public Quality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quality(int id, String qualityTheme, String originalType,
			String currentUnits, String categ, String inspectionMethods,
			String inspectionPersonnel, String inspectionDept,
			String inspectionDate) {
		super();
		this.id = id;
		this.qualityTheme = qualityTheme;
		this.originalType = originalType;
		this.currentUnits = currentUnits;
		this.categ = categ;
		this.inspectionMethods = inspectionMethods;
		this.inspectionPersonnel = inspectionPersonnel;
		this.inspectionDept = inspectionDept;
		this.inspectionDate = inspectionDate;
	}
	public Quality(String qualityTheme, String originalType,
			String currentUnits, String categ, String inspectionMethods,
			String inspectionPersonnel, String inspectionDept,
			String inspectionDate) {
		super();
		this.qualityTheme = qualityTheme;
		this.originalType = originalType;
		this.currentUnits = currentUnits;
		this.categ = categ;
		this.inspectionMethods = inspectionMethods;
		this.inspectionPersonnel = inspectionPersonnel;
		this.inspectionDept = inspectionDept;
		this.inspectionDate = inspectionDate;
	}
	public Quality(int id) {
		super();
		this.id = id;
	}
	
	
	
}
