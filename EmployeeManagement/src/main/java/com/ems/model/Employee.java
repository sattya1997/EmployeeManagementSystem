package com.ems.model;

public class Employee {
	private int eid;
	private String eName;
	private String DOJ;
	private int yoe;
	private String designation;

	public Employee(int eid, String eName, String dOJ, int yoe, String designation) {
		super();
		this.eid = eid;
		this.eName = eName;
		this.DOJ = dOJ;
		this.yoe = yoe;
		this.designation = designation;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public int getYoe() {
		return yoe;
	}

	public void setYoe(int yoe) {
		this.yoe = yoe;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}