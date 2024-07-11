package com.example.demo.PojoClass;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class FormDetailsPojo {
	
	private String staffNumberFormPojo;
	private String vehicleFleetNumberFormPojo;
	private String additionalInfoFormPojo;
	private String dateOfSubmitionFormPojo;
	private String timeOfSubmitionFormPojo;
	

}
