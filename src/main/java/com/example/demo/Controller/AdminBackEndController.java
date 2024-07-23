package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EntitiesClass.FormDetailsEntity;
import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.EntitiesClass.VehicleDetailsEntity;
import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.RepositoryClass.FormDetailsRepository;
import com.example.demo.RepositoryClass.StaffDetailsRepository;
import com.example.demo.RepositoryClass.VechicleDetailsRepository;
import com.example.demo.ServiceClass.FormEntityDataTransferManager;
import com.example.demo.ServiceClass.StaffEntityDataTransferManager;
import com.example.demo.ServiceClass.VehicleEntityDataTransferManager;
import com.fasterxml.jackson.annotation.JsonProperty;

@CrossOrigin(origins = "https://mtcreact.onrender.com")
@RestController
@RequestMapping("/admins")
public class AdminBackEndController {
	
	@Autowired
	FormDetailsRepository FormDetailsRepo;

	@Autowired
	StaffDetailsRepository  staffDetailsRepo;
	
	@Autowired
	VechicleDetailsRepository vechicleDetailsRepo;
	
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
	public String staffRegistration(@RequestBody StaffDetailsPojo staffPojoObj)
	{
		System.out.println("im in staff ");
		Optional<StaffDetailsEntity> staffObj = staffDetailsRepo.findById(staffPojoObj.getStaffNumberPojo());
		if(staffObj.isEmpty())
		{
			staffEntityDataTransferManager.addStaffDetailsToDataBase(staffPojoObj);
			return "Staff Registration SuccessFull";
		}
		else
			return "Staff is already Registered ";
		
	}
	
	@PostMapping("/regVehicle")
	public String vehicleRegistration(@RequestBody VehicleDetailsPojo vehiclePojoObj)
	{
		System.out.println("I am in vehicle Registration");
		Optional <VehicleDetailsEntity> vehicleObj =vechicleDetailsRepo.findById(vehiclePojoObj.getVehicleFleetNumberPojo());
		if(vehicleObj.isEmpty())
		{
			vehicleEntityDataTransferManager.addVechicleDataFromEntityToDataBase(vehiclePojoObj);
			return "Vehicle Registration SuccessFull";
		}
		else
			return "Vehicle is already Registered ";
	}
	
	@PostMapping("/regForm")
	public String formSubmission(@RequestBody FormDetailsPojo formPojoObj)
	{ 
		System.out.println("I am in  Form Submittion ");
		Optional<FormDetailsEntity> formObj = FormDetailsRepo.findById(formPojoObj.getVehicleFleetNumberFormPojo());
		if(formObj.isPresent())
		{
			FormDetailsEntity checkObj = formObj.get();
			LocalDateTime lastSubmissionTine = checkObj.getDateAndTimeOfSubmition();
			LocalDateTime currentTime = formEntityDataTransferManager.getSystemDateAndTime();
			Duration duration = Duration.between(lastSubmissionTine, currentTime);
			boolean isMoreThan24Hours = duration.toHours() > 24;
			if (isMoreThan24Hours) {
				formEntityDataTransferManager.addFormDataFromEntityToDataBase(formPojoObj);
				return "Inspection Form Submitted Successfully";
			} else {
				return "Today Form already Submitted ";
			}
		}
		else {
			formEntityDataTransferManager.addFormDataFromEntityToDataBase(formPojoObj);
			return "Inspection Form Submitted Successfully";
		}

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
	
	@PostMapping("/viewStaffById")
	public StaffDetailsPojo getStaffDetails(@RequestBody StaffDetailsPojo staffObj)
	{
		System.out.println(staffObj.getStaffNumberPojo());
		return staffEntityDataTransferManager.getStaffDetailsFromDataBase(staffObj.getStaffNumberPojo());
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
