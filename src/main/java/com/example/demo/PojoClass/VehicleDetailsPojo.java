package com.example.demo.PojoClass;

public class VehicleDetailsPojo {
	
	private String vehicleFleetNumberPojo ;
	private String vehicleServiceRoutePojo;
	private String vehicleDateOfCommencementPojo;
	private String vehicleModalPojo;
	
	//ToString
	@Override
	public String toString() {
		return "VehicleDetailsPojo [vehicleFleetNumberPojo=" + vehicleFleetNumberPojo + ", vehicleServiceRoutePojo="
				+ vehicleServiceRoutePojo + ", vehicleDateOfCommencementPojo=" + vehicleDateOfCommencementPojo
				+ ", vehicleModalPojo=" + vehicleModalPojo + "]";
	}
	
	
	//Constructor
	public VehicleDetailsPojo(String vehicleFleetNumberPojo, String vehicleServiceRoutePojo,
			String vehicleDateOfCommencementPojo, String vehicleModalPojo) {
		super();
		this.vehicleFleetNumberPojo = vehicleFleetNumberPojo;
		this.vehicleServiceRoutePojo = vehicleServiceRoutePojo;
		this.vehicleDateOfCommencementPojo = vehicleDateOfCommencementPojo;
		this.vehicleModalPojo = vehicleModalPojo;
	}

	//Getters and Setters 
	public String getVehicleFleetNumberPojo() {
		return vehicleFleetNumberPojo;
	}

	public void setVehicleFleetNumberPojo(String vehicleFleetNumberPojo) {
		this.vehicleFleetNumberPojo = vehicleFleetNumberPojo;
	}
	public String getVehicleServiceRoutePojo() {
		return vehicleServiceRoutePojo;
	}
	public void setVehicleServiceRoutePojo(String vehicleServiceRoutePojo) {
		this.vehicleServiceRoutePojo = vehicleServiceRoutePojo;
	}
	public String getVehicleDateOfCommencementPojo() {
		return vehicleDateOfCommencementPojo;
	}
	public void setVehicleDateOfCommencementPojo(String vehicleDateOfCommencementPojo) {
		this.vehicleDateOfCommencementPojo = vehicleDateOfCommencementPojo;
	}
	public String getVehicleModalPojo() {
		return vehicleModalPojo;
	}
	public void setVehicleModalPojo(String vehicleModalPojo) {
		this.vehicleModalPojo = vehicleModalPojo;
	}
	
	
	

	

}
