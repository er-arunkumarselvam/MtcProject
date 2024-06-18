package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
@RequestMapping("/userView")
public class UserFrontEndViewController {
	
	@RequestMapping("/FormReg")
	public ModelAndView viewFormVehicleRemarkPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FormDetails");
		return mv;
	}
	
	@RequestMapping("/login")
	public void checkUser(String staffNumberEntity , String staffPasswordEntity) {
		
	}

}
