package com.webServerProject.SpringProject1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.webServerProject.SpringProject1.Services.CalculatorServices;

@Controller
@RequestMapping(value ="/WelcomePage1")
public class CalculatorController {
	@Autowired
	CalculatorServices services;
	
	@ResponseBody
	@RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String WelcomeMessage() {
		return services.getResponse();
	}
	
	@ResponseBody
	@RequestMapping(value = "Operation/{Operation}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public double Operation(@PathVariable String Operation,@RequestParam int a,@RequestParam int b) {
		return services.Calculator(Operation,a,b);
	}
}