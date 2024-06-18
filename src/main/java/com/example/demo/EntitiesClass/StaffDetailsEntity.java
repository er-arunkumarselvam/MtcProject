package com.example.demo.EntitiesClass;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
@Service("/StaffEntity")
public class StaffDetailsEntity {
	
	@Id
	private String staffNumberEntity;
	
	private String staffNameEntity;
	private String staffDesignationEntity;
	private Long staffMobileNumberEntity;
	private String staffMailIdEntity;
	private String staffPasswordEntity;
	
	//Tostring
	@Override
	public String toString() {
		return "StaffDetailsEntity [staffNumberEntity=" + staffNumberEntity + ", staffNameEntity=" + staffNameEntity
				+ ", staffDesignationEntity=" + staffDesignationEntity + ", staffMobileNumberEntity="
				+ staffMobileNumberEntity + ", staffMailIdEntity=" + staffMailIdEntity + ", staffPasswordEntity="
				+ staffPasswordEntity + "]";
	}
	
//	//Constructor
//	public StaffDetailsEntity(String staffNumberEntity, String staffNameEntity, String staffDesignationEntity,
//			Long staffMobileNumberEntity, String staffMailIdEntity, String staffPasswordEntity) {
//		super();
//		this.staffNumberEntity = staffNumberEntity;
//		this.staffNameEntity = staffNameEntity;
//		this.staffDesignationEntity = staffDesignationEntity;
//		this.staffMobileNumberEntity = staffMobileNumberEntity;
//		this.staffMailIdEntity = staffMailIdEntity;
//		this.staffPasswordEntity = staffPasswordEntity;
//	}
//
//	// zero Argument Constructor 
//	public StaffDetailsEntity()
//	{
//		
//	}
	//Getter and Setter
	
	public String getStaffMailIdEntity() {
		return staffMailIdEntity;
	}

	public void setStaffMailIdEntity(String staffMailIdEntity) {
		this.staffMailIdEntity = staffMailIdEntity;
	}
	
	public String getStaffNumberEntity() {
		return staffNumberEntity;
	}

	public void setStaffNumberEntity(String staffNumberEntity) {
		this.staffNumberEntity = staffNumberEntity;
	}
	public String getStaffNameEntity() {
		return staffNameEntity;
	}
	public void setStaffNameEntity(String staffNameEntity) {
		this.staffNameEntity = staffNameEntity;
	}
	public String getStaffDesignationEntity() {
		return staffDesignationEntity;
	}
	public void setStaffDesignationEntity(String staffDesignationEntity) {
		this.staffDesignationEntity = staffDesignationEntity;
	}
	public Long getStaffMobileNumberEntity() {
		return staffMobileNumberEntity;
	}
	public void setStaffMobileNumberEntity(Long staffMobileNumberEntity) {
		this.staffMobileNumberEntity = staffMobileNumberEntity;
	}
	public String getStaffPasswordEntity() {
		return staffPasswordEntity;
	}
	public void setStaffPasswordEntity(String staffPasswordEntity) {
		this.staffPasswordEntity = staffPasswordEntity;
	}
	
	

}
