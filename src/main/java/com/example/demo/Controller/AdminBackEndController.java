package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.ServiceClass.AddFormDataFromEntityToDataBase;
import com.example.demo.ServiceClass.AddStaffDataFromEntityToDataBase;
import com.example.demo.ServiceClass.AddVehicleDataFromEntityToDataBase;


@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminBackEndController {
	
	@Autowired
	@Qualifier("/StaffDetails")
	public AddStaffDataFromEntityToDataBase addStaffDataFromEntityToDataBaseObj;
	
	
	@Autowired
	@Qualifier("/VehicleDetails")
	public AddVehicleDataFromEntityToDataBase addVehicleDataFromEntityToDataBaseObj;
	
	@Autowired
	@Qualifier("/FormDetails")
	public AddFormDataFromEntityToDataBase addFormDataFromEntityToDataBaseObj;
	
	@PostMapping("/StaffReg")
	public StaffDetailsPojo staffRegistration(StaffDetailsPojo staffDetailsPojoObj)
	{
		System.out.println("im in staff ");
		addStaffDataFromEntityToDataBaseObj.addStaffDetailsToDataBase(staffDetailsPojoObj);
		System.out.println(staffDetailsPojoObj);
		return staffDetailsPojoObj;
		
	}
	
	@PostMapping("/regVehicle")
	public VehicleDetailsPojo vehicleRegistration(VehicleDetailsPojo vehicleDetailsPojoObj)
	{
		System.out.println("I am in vehicle Registration");
		addVehicleDataFromEntityToDataBaseObj.addVechicleDataFromEntityToDataBase(vehicleDetailsPojoObj);
		return vehicleDetailsPojoObj;
	}
	
	@PostMapping("/regForm")
	public FormDetailsPojo formSubmission(FormDetailsPojo formDetailsPojoObj)
	{
		System.out.println("I am in  Form Submittion ");
		addFormDataFromEntityToDataBaseObj.addFormDataFromEntityToDataBase(formDetailsPojoObj);
		return formDetailsPojoObj;
	}
	




}
