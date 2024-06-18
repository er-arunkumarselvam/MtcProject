package com.example.demo.PojoClass;

public class FormDetailsPojo {
	
	private String staffNumberFormPojo;
	private String vehicleFleetNumberFormPojo;
	private String additionalInfoFormPojo;
	
	//ToString 
	@Override
	public String toString() {
		return "FormDetailsPojo [staffNumberFormPojo=" + staffNumberFormPojo + ", vehicleFleetNumberFormPojo="
				+ vehicleFleetNumberFormPojo + ", additionalInfoFormPojo="
				+ additionalInfoFormPojo + "]";
	}
	
	
	//Constructor
	public FormDetailsPojo(String staffNumberFormPojo, String vehicleFleetNumberFormPojo,
		 String additionalInfoFormPojo) {
		super();
		this.staffNumberFormPojo = staffNumberFormPojo;
		this.vehicleFleetNumberFormPojo = vehicleFleetNumberFormPojo;
		this.additionalInfoFormPojo = additionalInfoFormPojo;
	}

	//Getter and Setter
	public String getStaffNumberFormPojo() {
		return staffNumberFormPojo;
	}
	public void setStaffNumberFormPojo(String staffNumberFormPojo) {
		this.staffNumberFormPojo = staffNumberFormPojo;
	}
	public String getVehicleFleetNumberFormPojo() {
		return vehicleFleetNumberFormPojo;
	}
	public void setVehicleFleetNumberFormPojo(String vehicleFleetNumberFormPojo) {
		this.vehicleFleetNumberFormPojo = vehicleFleetNumberFormPojo;
	}
	public String getAdditionalInfoFormPojo() {
		return additionalInfoFormPojo;
	}
	public void setAdditionalInfoFormPojo(String additionalInfoFormPojo) {
		this.additionalInfoFormPojo = additionalInfoFormPojo;
	}
	

	

}
