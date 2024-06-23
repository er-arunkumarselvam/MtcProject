package com.example.demo.EntitiesClass;

import org.springframework.stereotype.Service;

import com.example.demo.PojoClass.VehicleDetailsPojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Service("/formEntityObj")
@Entity
@Data
public class FormDetailsEntity {
	@Id
	private String vehicleFleetNumberFormEntity;
	private String staffNumberFormEntity;
	private String dateOfSubmitionFormEntity;
	private String timeOfSubmitionFormEntity;
	private String additionalInfoFormEntity;
	

}
