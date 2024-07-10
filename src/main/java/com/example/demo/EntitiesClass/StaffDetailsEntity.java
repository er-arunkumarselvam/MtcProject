package com.example.demo.EntitiesClass;
import org.springframework.stereotype.Service;

import com.example.demo.PojoClass.VehicleDetailsPojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Service("/StaffEntity")
public class StaffDetailsEntity {
	
	@Id
	private String staffNumberEntity;
	
	private String staffNameEntity;
	private String staffDesignationEntity;
	private Long staffMobileNumberEntity;
	private String staffMailIdEntity;
	private String staffPasswordEntity;	
	private String staffRoleEntity;

}
