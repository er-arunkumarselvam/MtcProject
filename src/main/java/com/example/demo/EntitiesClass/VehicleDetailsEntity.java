package com.example.demo.EntitiesClass;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Service("/vehicleDetailsEntity")
public class VehicleDetailsEntity {
	
	@Id
	private String vehicleFleetNumberEntity ;
	private String vehicleServiceRouteEntity;
	private String vehicleDateOfCommencementEntity;
	private String vehicleModalEntity;
	
	//Constructor
	public VehicleDetailsEntity(String vehicleFleetNumberEntity, String vehicleServiceRouteEntity,
			String vehicleDateOfCommencementEntity, String vehicleModalEntity) {
		super();
		this.vehicleFleetNumberEntity = vehicleFleetNumberEntity;
		this.vehicleServiceRouteEntity = vehicleServiceRouteEntity;
		this.vehicleDateOfCommencementEntity = vehicleDateOfCommencementEntity;
		this.vehicleModalEntity = vehicleModalEntity;
	}
	//Zero Argument Constructor
	public VehicleDetailsEntity()
	{
		
	}
	//Getter and Setter
	public String getVehicleFleetNumberEntity() {
		return vehicleFleetNumberEntity;
	}

	public void setVehicleFleetNumberEntity(String vehicleFleetNumberEntity) {
		this.vehicleFleetNumberEntity = vehicleFleetNumberEntity;
	}

	public String getVehicleServiceRouteEntity() {
		return vehicleServiceRouteEntity;
	}

	public void setVehicleServiceRouteEntity(String vehicleServiceRouteEntity) {
		this.vehicleServiceRouteEntity = vehicleServiceRouteEntity;
	}

	public String getVehicleDateOfCommencementEntity() {
		return vehicleDateOfCommencementEntity;
	}

	public void setVehicleDateOfCommencementEntity(String vehicleDateOfCommencementEntity) {
		this.vehicleDateOfCommencementEntity = vehicleDateOfCommencementEntity;
	}

	public String getVehicleModalEntity() {
		return vehicleModalEntity;
	}

	public void setVehicleModalEntity(String vehicleModalEntity) {
		this.vehicleModalEntity = vehicleModalEntity;
	}

	//ToString
	@Override
	public String toString() {
		return "VechivleDetailsEntity [vehicleFleetNumberEntity=" + vehicleFleetNumberEntity
				+ ", vehicleServiceRouteEntity=" + vehicleServiceRouteEntity + ", vehicleDateOfCommencementEntity="
				+ vehicleDateOfCommencementEntity + ", vehicleModalEntity=" + vehicleModalEntity + "]";
	}
	
	
	
	

}
