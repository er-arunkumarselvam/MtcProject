package com.example.demo.ServiceClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.RepositoryClass.StaffDetailsRepository;

@Service("/StaffDetails")
public class AddStaffDataFromEntityToDataBase {
	
	@Autowired
	@Qualifier("/StaffEntity")
	public StaffDetailsEntity staffDetailsEntityObj;
	
	@Autowired
	@Qualifier("/StaffRepo")
	public StaffDetailsRepository staffDetailsRepObj;
	
	public void addStaffDataFromPojoToEntity(StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("Iam in pojo to entity");
		staffDetailsEntityObj.setStaffNameEntity(staffDetailsPojoObj.getStaffNamePojo());
		staffDetailsEntityObj.setStaffNumberEntity(staffDetailsPojoObj.getStaffNumberPojo());
		staffDetailsEntityObj.setStaffDesignationEntity(staffDetailsPojoObj.getStaffDesignationPojo());
		staffDetailsEntityObj.setStaffMobileNumberEntity(staffDetailsPojoObj.getStaffMobileNumberPojo());
		staffDetailsEntityObj.setStaffMailIdEntity(staffDetailsPojoObj.getStaffMailIdPojo());
		setStaffPasswordForEntity(staffDetailsPojoObj);
		
	}
	
	public void setStaffPasswordForEntity(StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("Iam in password ");
		String password = "";
		password = password+staffDetailsPojoObj.getStaffNumberPojo()+"@TA";
		staffDetailsEntityObj.setStaffPasswordEntity(password);
	}
	public void addStaffDetailsToDataBase(StaffDetailsPojo staffDetailsPojoObj)
	{
		addStaffDataFromPojoToEntity(staffDetailsPojoObj);
		staffDetailsRepObj.save(staffDetailsEntityObj);
		
	}
}
