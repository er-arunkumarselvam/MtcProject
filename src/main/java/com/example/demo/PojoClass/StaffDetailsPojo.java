package com.example.demo.PojoClass;


public class StaffDetailsPojo {
	
	private String staffNumberPojo;
	private String staffNamePojo;
	private String staffDesignationPojo;
	private Long staffMobileNumberPojo;
	private String staffMailIdPojo;
	
	//COnstructor 
	public StaffDetailsPojo(String staffNumberPojo, String staffNamePojo, String staffDesignationPojo,
			Long staffMobileNumberPojo, String staffMailIdPojo) {
		super();
		this.staffNumberPojo = staffNumberPojo;
		this.staffNamePojo = staffNamePojo;
		this.staffDesignationPojo = staffDesignationPojo;
		this.staffMobileNumberPojo = staffMobileNumberPojo;
		this.staffMailIdPojo = staffMailIdPojo;
	}
	
	//TOstring Overriding
	@Override
	public String toString() {
		return "StaffDetailsPojo [staffNumberPojo=" + staffNumberPojo + ", staffNamePojo=" + staffNamePojo
				+ ", staffDesignationPojo=" + staffDesignationPojo + ", staffMobileNumberPojo=" + staffMobileNumberPojo
				+ ", staffMailIdPojo=" + staffMailIdPojo + "]";
	}

	//Getters and Setters
	public String getStaffMailIdPojo() {
		return staffMailIdPojo;
	}

	public void setStaffMailIdPojo(String staffMailIdPojo) {
		this.staffMailIdPojo = staffMailIdPojo;
	}
	
	public String getStaffNumberPojo() {
		return staffNumberPojo;
	}

	public void setStaffNumberPojo(String staffNumberPojo) {
		this.staffNumberPojo = staffNumberPojo;
	}
	public String getStaffNamePojo() {
		return staffNamePojo;
	}
	public void setStaffNamePojo(String staffNamePojo) {
		this.staffNamePojo = staffNamePojo;
	}
	public String getStaffDesignationPojo() {
		return staffDesignationPojo;
	}
	public void setStaffDesignationPojo(String staffDesignationPojo) {
		this.staffDesignationPojo = staffDesignationPojo;
	}
	public Long getStaffMobileNumberPojo() {
		return staffMobileNumberPojo;
	}
	public void setStaffMobileNumberPojo(Long staffMobileNumberPojo) {
		this.staffMobileNumberPojo = staffMobileNumberPojo;
	}
	
	

}
