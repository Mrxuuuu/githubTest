package com.xuwem.show.pojo;


public class Department{

	private int depId;
	private String depName;
	private String depDuty;
	private String depStatu;
	private String depDesc;
	
	public Department() {
		super();
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepDuty() {
		return depDuty;
	}
	public void setDepDuty(String depDuty) {
		this.depDuty = depDuty;
	}
	public String getDepStatu() {
		return depStatu;
	}
	public void setDepStatu(String depStatu) {
		this.depStatu = depStatu;
	}
	public String getDepDesc() {
		return depDesc;
	}
	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depDuty=" + depDuty + ", depStatu=" + depStatu
				+ ", depDesc=" + depDesc + "]";
	}
	
	
}
