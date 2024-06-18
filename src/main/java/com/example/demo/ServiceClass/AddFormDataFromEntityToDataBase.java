package com.example.demo.ServiceClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.FormDetailsEntity;
import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.RepositoryClass.FormDetailsRepository;

@Service("/FormDetails")
public class AddFormDataFromEntityToDataBase {
	
	@Autowired
	@Qualifier("/formRepObj")
	public FormDetailsRepository formDetailsRepositoryObj;
	
	@Autowired
	@Qualifier("/formEntityObj")
	public FormDetailsEntity formDetailsEntityObj; 
	
	public void addSystemDateAndTimeToEntity()
	{
		LocalDateTime myDateAndTimeObj = LocalDateTime.now();
		DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");  
		String currentDate = myDateAndTimeObj.format(myDateFormat);
		String currentTime = myDateAndTimeObj.format(myTimeFormat);
		formDetailsEntityObj.setDateOfSubmitionFormEntity(currentDate);
		formDetailsEntityObj.setTimeOfSubmitionFormEntity(currentTime);
		System.out.println(currentDate);
		System.out.println(currentTime);
	}
	public void addFormDataFromPojoToEntity(FormDetailsPojo formDetailsPojoObj)
	{
		formDetailsEntityObj.setStaffNumberFormEntity(formDetailsPojoObj.getStaffNumberFormPojo());
		formDetailsEntityObj.setVehicleFleetNumberFormEntity(formDetailsPojoObj.getVehicleFleetNumberFormPojo());
		formDetailsEntityObj.setAdditionalInfoFormEntity(formDetailsPojoObj.getVehicleFleetNumberFormPojo());
		addSystemDateAndTimeToEntity();
	}
	
	public void addFormDataFromEntityToDataBase(FormDetailsPojo formDetailsPojoObj)
	{
		addFormDataFromPojoToEntity(formDetailsPojoObj);
		formDetailsRepositoryObj.save(formDetailsEntityObj);
	}

}
