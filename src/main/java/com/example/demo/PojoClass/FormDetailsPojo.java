package com.example.demo.PojoClass;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class FormDetailsPojo {
	
	private String staffNumberFormPojo;
	private String vehicleFleetNumberFormPojo;
	private String additionalInfoFormPojo;
	private LocalDateTime dateAndTimeOfSubmition;
	

}
