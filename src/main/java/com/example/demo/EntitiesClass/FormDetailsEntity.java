package com.example.demo.EntitiesClass;

import java.time.LocalDateTime;

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
	private String vehicleFleetFormEntity;
	
	private String staffNumberFormEntity;
	private LocalDateTime dateAndTimeOfSubmition;
	private String additionalInfoFormEntity;
	

}
