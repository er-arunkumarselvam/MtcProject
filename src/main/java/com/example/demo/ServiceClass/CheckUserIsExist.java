package com.example.demo.ServiceClass;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.RepositoryClass.StaffDetailsRepository;

public class CheckUserIsExist {
	
	@Autowired
	@Qualifier("/StaffRepo")
	public StaffDetailsRepository staffDetailsRepObj;
	
	
	public String checkUserDetailInDataBase(String userId, String password)
	{
		Optional<StaffDetailsEntity> staffObj =staffDetailsRepObj.findById(userId);
		
		return null;
	}

}
