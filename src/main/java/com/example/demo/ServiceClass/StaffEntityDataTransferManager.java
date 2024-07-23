package com.example.demo.ServiceClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.EntitiesClass.VehicleDetailsEntity;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.RepositoryClass.StaffDetailsRepository;

@Service("/StaffDetails")
public class StaffEntityDataTransferManager {
	
	@Autowired
	@Qualifier("/StaffEntity")
	public StaffDetailsEntity staffDetailsEntityObj;
	
	@Autowired
	@Qualifier("/StaffRepo")
	public StaffDetailsRepository staffDetailsRepObj;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataTransferClass dataTransferClassObj;
	
	
	public void addStaffDataFromPojoToEntity(StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("Iam in pojo to entity");
		staffDetailsEntityObj = dataTransferClassObj.staffDetailsPojoToEntity(staffDetailsPojoObj);
		setStaffPasswordForEntity(staffDetailsPojoObj);
	}
	
	public void setStaffPasswordForEntity(StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("Iam in password ");
		String password = "";
		password = password+staffDetailsPojoObj.getStaffNumberPojo()+"@TA";
		staffDetailsEntityObj.setStaffPasswordEntity(passwordEncoder.encode(password));
	}
	public void addStaffDetailsToDataBase(StaffDetailsPojo staffDetailsPojoObj)
	{
		addStaffDataFromPojoToEntity(staffDetailsPojoObj);
		staffDetailsRepObj.save(staffDetailsEntityObj);	
	}
	
    // READ ALL DATA
    public List<StaffDetailsPojo> getAllStaffDetailsFromDataBase() {
        Iterable<StaffDetailsEntity> data = staffDetailsRepObj.findAll();
        List<StaffDetailsEntity> dataList = new ArrayList<>();
        data.forEach(dataList::add); // Convert Iterable to List
        
        //list of entity to list of pojo
        List<StaffDetailsPojo> pojoList = dataList.stream()
                .map(dataTransferClassObj::staffDetailsEntityToPojo)
                .collect(Collectors.toList());
        return pojoList;
    }
    
    //READ SINGLE DATA
    public StaffDetailsPojo getStaffDetailsFromDataBase(String staffNumber) {
    	System.out.println(staffNumber);
       Optional<StaffDetailsEntity> data = staffDetailsRepObj.findById(staffNumber);
       if(data.isPresent()) {
    	   System.out.println("data is present --------------------");
    	   StaffDetailsEntity userData = data.get();
    	   return dataTransferClassObj.staffDetailsEntityToPojo(userData);
       }
       System.out.println("data is not present --------------------");
        return null;
    }
	
    // UPDATE DATA 
    public String updateStaffDetails(StaffDetailsPojo staffObj)
    {
    	Optional<StaffDetailsEntity> data = staffDetailsRepObj.findById(staffObj.getStaffNumberPojo());
    	if(data.isPresent())
    	{
    		StaffDetailsEntity updatedStaff= data.get();
    		updatedStaff = dataTransferClassObj.staffDetailsPojoToEntity(staffObj);
    		staffDetailsRepObj.save(updatedStaff);
    		return "Successfully updated Staff Details";
    	}
    	else
    		return "Invalid StaffNo";
    }
	
	
	
}
