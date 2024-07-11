package com.example.demo.PojoClass;

import org.springframework.stereotype.Service;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Service
public class VehicleDetailsPojo {
	
	private String vehicleFleetNumberPojo ;
	private String vehicleServiceRoutePojo;
	private String vehicleDateOfCommencementPojo;
	private String vehicleModalPojo;
	

}
