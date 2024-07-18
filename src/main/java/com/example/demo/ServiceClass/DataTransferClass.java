package com.example.demo.ServiceClass;

import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.FormDetailsEntity;
import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.EntitiesClass.VehicleDetailsEntity;
import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;

@Service
public class DataTransferClass {
	
	public StaffDetailsEntity staffDetailsPojoToEntity(StaffDetailsPojo staffDetailsPojo)
	{
		StaffDetailsEntity staffEntityObj = new StaffDetailsEntity();
		staffEntityObj.setStaffNumberEntity(staffDetailsPojo.getStaffNumberPojo());
		staffEntityObj.setStaffNameEntity(staffDetailsPojo.getStaffNamePojo());
		staffEntityObj.setStaffDesignationEntity(staffDetailsPojo.getStaffDesignationPojo());
		staffEntityObj.setStaffRoleEntity(staffDetailsPojo.getStaffRolePojo());
		staffEntityObj.setStaffMailIdEntity(staffDetailsPojo.getStaffMailIdPojo());
		staffEntityObj.setStaffMobileNumberEntity(staffDetailsPojo.getStaffMobileNumberPojo());
		return staffEntityObj;
	}
	
	public StaffDetailsPojo staffDetailsEntityToPojo(StaffDetailsEntity staffDetailsEntity) 
	{
		StaffDetailsPojo staffPojoObj = new StaffDetailsPojo();
		staffPojoObj.setStaffNumberPojo(staffDetailsEntity.getStaffNumberEntity());
		staffPojoObj.setStaffNamePojo(staffDetailsEntity.getStaffNameEntity());
		staffPojoObj.setStaffDesignationPojo(staffDetailsEntity.getStaffDesignationEntity());
		staffPojoObj.setStaffRolePojo(staffDetailsEntity.getStaffRoleEntity());
		staffPojoObj.setStaffMailIdPojo(staffDetailsEntity.getStaffMailIdEntity());
		staffPojoObj.setStaffMobileNumberPojo(staffDetailsEntity.getStaffMobileNumberEntity());
		return staffPojoObj;
	}
	
	public VehicleDetailsPojo vehicleDetailsEntityToPojo(VehicleDetailsEntity vehicleDetailsEntity)
	{
		VehicleDetailsPojo vehiclePojoObj = new VehicleDetailsPojo();
		vehiclePojoObj.setVehicleFleetNumberPojo(vehicleDetailsEntity.getVehicleFleetNumberEntity());
		vehiclePojoObj.setVehicleDateOfCommencementPojo(vehicleDetailsEntity.getVehicleDateOfCommencementEntity());
		vehiclePojoObj.setVehicleModalPojo(vehicleDetailsEntity.getVehicleModalEntity());
		vehiclePojoObj.setVehicleServiceRoutePojo(vehicleDetailsEntity.getVehicleServiceRouteEntity());
		return vehiclePojoObj;
	}
	
	public VehicleDetailsEntity vehicleDetailsPojoToEntity(VehicleDetailsPojo vehicleDetailsPojo)
	{
		VehicleDetailsEntity vehicleEntityObj = new VehicleDetailsEntity();
		vehicleEntityObj.setVehicleFleetNumberEntity(vehicleDetailsPojo.getVehicleFleetNumberPojo());
		vehicleEntityObj.setVehicleDateOfCommencementEntity(vehicleDetailsPojo.getVehicleDateOfCommencementPojo());
		vehicleEntityObj.setVehicleModalEntity(vehicleDetailsPojo.getVehicleModalPojo());
		vehicleEntityObj.setVehicleServiceRouteEntity(vehicleDetailsPojo.getVehicleServiceRoutePojo());
		return vehicleEntityObj;
	}
	
	public FormDetailsEntity formDetailsPojoToEntity(FormDetailsPojo formDetailsPojo)
	{
		FormDetailsEntity formEntityObj = new FormDetailsEntity();
		formEntityObj.setVehicleFleetFormEntity(formDetailsPojo.getVehicleFleetNumberFormPojo());
		formEntityObj.setStaffNumberFormEntity(formDetailsPojo.getStaffNumberFormPojo());
		formEntityObj.setAdditionalInfoFormEntity(formDetailsPojo.getAdditionalInfoFormPojo());
		return formEntityObj;
	}
	
	public FormDetailsPojo formDetailsEntityToPojo(FormDetailsEntity formDetailsEntity)
	{
		FormDetailsPojo formPojoObj = new FormDetailsPojo();
		formPojoObj.setVehicleFleetNumberFormPojo(formDetailsEntity.getVehicleFleetFormEntity());
		formPojoObj.setStaffNumberFormPojo(formDetailsEntity.getStaffNumberFormEntity());
		formPojoObj.setAdditionalInfoFormPojo(formDetailsEntity.getAdditionalInfoFormEntity());
		formPojoObj.setDateAndTimeOfSubmition(formDetailsEntity.getDateAndTimeOfSubmition());
		return formPojoObj;
	}
	
	

}
