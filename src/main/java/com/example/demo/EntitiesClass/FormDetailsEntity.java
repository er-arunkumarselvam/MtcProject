package com.example.demo.EntitiesClass;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Service("/formEntityObj")
@Entity
@Data
@Table
public class FormDetailsEntity {
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String vehicleFleetNumberFormEntity;
	
	private String staffNumberFormEntity;
	private String dateOfSubmitionFormEntity;
	private String timeOfSubmitionFormEntity;
	private String additionalInfoFormEntity;
	

}
