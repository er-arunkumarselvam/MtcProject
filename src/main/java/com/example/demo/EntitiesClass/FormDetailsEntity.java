package com.example.demo.EntitiesClass;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Service("/formEntityObj")
@Entity
public class FormDetailsEntity {
	@Id
	private String vehicleFleetNumberFormEntity;
	private String staffNumberFormEntity;
	private String dateOfSubmitionFormEntity;
	private String timeOfSubmitionFormEntity;
	private String additionalInfoFormEntity;
	
	//ToString
	@Override
	public String toString() {
		return "FormDetailsEntity [staffNumberFormEntity=" + staffNumberFormEntity + ", vehicleFleetNumberFormEntity="
				+ vehicleFleetNumberFormEntity + ", dateOfSubmitionFormEntity=" + dateOfSubmitionFormEntity
				+ ", timeOfSubmitionFormEntity=" + timeOfSubmitionFormEntity + ", additionalInfoFormEntity="
				+ additionalInfoFormEntity + "]";
	}
	
	//Constructor
	public FormDetailsEntity(String staffNumberFormEntity, String vehicleFleetNumberFormEntity,
			String dateOfSubmitionFormEntity, String timeOfSubmitionFormEntity, String additionalInfoFormEntity) {
		super();
		this.staffNumberFormEntity = staffNumberFormEntity;
		this.vehicleFleetNumberFormEntity = vehicleFleetNumberFormEntity;
		this.dateOfSubmitionFormEntity = dateOfSubmitionFormEntity;
		this.timeOfSubmitionFormEntity = timeOfSubmitionFormEntity;
		this.additionalInfoFormEntity = additionalInfoFormEntity;
	}


	// Zero Arguments Constructor
	public FormDetailsEntity()
	{
		
	}
	
	//Setter and Getter
	public String getStaffNumberFormEntity() {
		return staffNumberFormEntity;
	}
	public void setStaffNumberFormEntity(String staffNumberFormEntity) {
		this.staffNumberFormEntity = staffNumberFormEntity;
	}
	public String getVehicleFleetNumberFormEntity() {
		return vehicleFleetNumberFormEntity;
	}
	public void setVehicleFleetNumberFormEntity(String vehicleFleetNumberFormEntity) {
		this.vehicleFleetNumberFormEntity = vehicleFleetNumberFormEntity;
	}
	public String getDateOfSubmitionFormEntity() {
		return dateOfSubmitionFormEntity;
	}
	public void setDateOfSubmitionFormEntity(String dateOfSubmitionFormEntity) {
		this.dateOfSubmitionFormEntity = dateOfSubmitionFormEntity;
	}
	public String getTimeOfSubmitionFormEntity() {
		return timeOfSubmitionFormEntity;
	}
	public void setTimeOfSubmitionFormEntity(String timeOfSubmitionFormEntity) {
		this.timeOfSubmitionFormEntity = timeOfSubmitionFormEntity;
	}
	public String getAdditionalInfoFormEntity() {
		return additionalInfoFormEntity;
	}
	public void setAdditionalInfoFormEntity(String additionalInfoFormEntity) {
		this.additionalInfoFormEntity = additionalInfoFormEntity;
	}
	

	

}
