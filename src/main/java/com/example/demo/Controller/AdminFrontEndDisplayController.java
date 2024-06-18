package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
@RequestMapping("/adminView")
public class AdminFrontEndDisplayController {
	
	@RequestMapping("StaffReg")
	public ModelAndView viewStaffRegistrationPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("StaffDetails");
		return mv;
	}
	
	@RequestMapping("VehicleReg")
	public ModelAndView viewVehicleRegistrationPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("VehicleDetails");
		return mv;
	}
	

}
