package com.example.demo.ServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.VehicleDetailsEntity;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.RepositoryClass.StaffDetailsRepository;
import com.example.demo.RepositoryClass.VechicleDetailsRepository;

@Service("/VehicleDetails")
public class AddVehicleDataFromEntityToDataBase {
	
	@Autowired
	@Qualifier("/vehicleDetailsEntity")
	public VehicleDetailsEntity vehicleDetailsEntityObj; 
	
	@Autowired
	@Qualifier("/vehicleDetailsRepo")
	public VechicleDetailsRepository vechicleDetailsRepositoryObj;
	
	public void addVehicleDataFromPojoToEntity(VehicleDetailsPojo vehicleDetailsPojoObj)
	{
		vehicleDetailsEntityObj.setVehicleFleetNumberEntity(vehicleDetailsPojoObj.getVehicleFleetNumberPojo());
		vehicleDetailsEntityObj.setVehicleDateOfCommencementEntity(vehicleDetailsPojoObj.getVehicleDateOfCommencementPojo());
		vehicleDetailsEntityObj.setVehicleServiceRouteEntity(vehicleDetailsPojoObj.getVehicleServiceRoutePojo());
		vehicleDetailsEntityObj.setVehicleModalEntity(vehicleDetailsPojoObj.getVehicleModalPojo());
	}
	
	public void addVechicleDataFromEntityToDataBase(VehicleDetailsPojo vehicleDetailsPojoObj)
	{
		addVehicleDataFromPojoToEntity(vehicleDetailsPojoObj);
		vechicleDetailsRepositoryObj.save(vehicleDetailsEntityObj);
	}

}
