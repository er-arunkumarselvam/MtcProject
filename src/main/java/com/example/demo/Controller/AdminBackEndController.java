package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.ServiceClass.FormEntityDataTransferManager;
import com.example.demo.ServiceClass.StaffEntityDataTransferManager;
import com.example.demo.ServiceClass.VehicleEntityDataTransferManager;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admins")
public class AdminBackEndController {

	@Autowired
	@Qualifier("/StaffDetails")
	public StaffEntityDataTransferManager staffEntityDataTransferManager;
	
	
	@Autowired
	@Qualifier("/VehicleDetails")
	public VehicleEntityDataTransferManager vehicleEntityDataTransferManager;
	
	@Autowired
	@Qualifier("/FormDetails")
	public FormEntityDataTransferManager formEntityDataTransferManager;
	
	@PostMapping("/StaffReg")
	public StaffDetailsPojo staffRegistration(@RequestBody StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("im in staff ");
		staffEntityDataTransferManager.addStaffDetailsToDataBase(staffDetailsPojoObj);
		System.out.println(staffDetailsPojoObj);
		return staffDetailsPojoObj;
		
	}
	
	@PostMapping("/regVehicle")
	public VehicleDetailsPojo vehicleRegistration(@RequestBody VehicleDetailsPojo vehicleDetailsPojoObj)
	{
		System.out.println("I am in vehicle Registration");
		vehicleEntityDataTransferManager.addVechicleDataFromEntityToDataBase(vehicleDetailsPojoObj);
		return vehicleDetailsPojoObj;
	}
	
	@PostMapping("/regForm")
	public FormDetailsPojo formSubmission(@RequestBody FormDetailsPojo formDetailsPojoObj)
	{
		System.out.println("I am in  Form Submittion ");
		formEntityDataTransferManager.addFormDataFromEntityToDataBase(formDetailsPojoObj);
		return formDetailsPojoObj;
	}
	
	@GetMapping("/viewVehicles")
	public List<VehicleDetailsPojo> getAllVehicleDetails()
	{
		return vehicleEntityDataTransferManager.getAllVehicleDetailsFromDataBase();
	}
	
	@GetMapping("/viewStaff")
	public List<StaffDetailsPojo> getAllStaffDetails()
	{
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return staffEntityDataTransferManager.getAllStaffDetailsFromDataBase();
	}
	
	@GetMapping("/viewForm")
	public List<FormDetailsPojo> getAllFormDetails()
	{
		return formEntityDataTransferManager.getAllFormDetailsFromDataBase();
	}
	
	@GetMapping("/change")
	@ResponseBody
	public String check()
	{
		System.out.println("-------------------check--------");
		return "im working";
	}

}
