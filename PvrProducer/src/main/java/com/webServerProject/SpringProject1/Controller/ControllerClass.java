package com.webServerProject.SpringProject1.Controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServerProject.SpringProject1.Services.EmployeeDetails;
import com.webServerProject.SpringProject1.Services.Services;

@RestController
@RequestMapping(value ="/WelcomePage")
public class ControllerClass {
	@Autowired 
	Services services;
	
	@GetMapping(value = "")
	public String WelcomeMessage() {
		return services.getResponse();
	}
	
	@GetMapping(value = "/Employee")
	public HashMap<String,EmployeeDetails> AllEmployeeDetails() {
		return services.getEmpDetails();
	}
	
	@GetMapping(value = "/Employee/{EmpId}")
	public EmployeeDetails Employee(@PathVariable String EmpId) {
		return services.Employee(EmpId);
	}
	
	@PostMapping(value = "/add")
	public HashMap<String,EmployeeDetails> AddEmployee(@RequestBody EmployeeDetails Emp) {
		return services.addEmployee(Emp);
	}
	
	@DeleteMapping(value = "/delete")
	public HashMap<String,EmployeeDetails> DeleteEmployee(@RequestBody EmployeeDetails Emp) {
		return services.deleteEmployee(Emp);
	}
	
}