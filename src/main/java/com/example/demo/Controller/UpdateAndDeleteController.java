package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.ServiceClass.StaffEntityDataTransferManager;
import com.example.demo.ServiceClass.VehicleEntityDataTransferManager;

@RestController
public class UpdateAndDeleteController {
	
	@Autowired
	VehicleEntityDataTransferManager vehicleDtmObj;
	
	@Autowired
	StaffEntityDataTransferManager staffDtmObj;
	
	@PostMapping("update/vehicleDetails")
	@ResponseBody
	public String updateVehicleDetails(@RequestBody VehicleDetailsPojo pojoObj)
	{
		System.out.println("im in update ");
		return vehicleDtmObj.updateVehicleDetails(pojoObj);
	}
	
	@PostMapping("update/staffDetails")
	@ResponseBody
	public String updateStaffDetails(@RequestBody StaffDetailsPojo pojoObj)
	{
		System.out.println("im in update ");
		return staffDtmObj.updateStaffDetails(pojoObj);
	}

}
