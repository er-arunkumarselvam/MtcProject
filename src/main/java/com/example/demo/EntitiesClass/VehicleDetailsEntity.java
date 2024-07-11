package com.example.demo.EntitiesClass;

import org.springframework.stereotype.Service;

import com.example.demo.PojoClass.VehicleDetailsPojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Service("/vehicleDetailsEntity")
public class VehicleDetailsEntity {
	
	@Id
	private String vehicleFleetNumberEntity ;
	
	private String vehicleServiceRouteEntity;
	private String vehicleDateOfCommencementEntity;
	private String vehicleModalEntity;

}
