package com.webServerProject.SpringProject1.Services;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class Services {
	public HashMap<String,EmployeeDetails> empDetails=new HashMap<String, EmployeeDetails>();
	
	public String getResponse(){
		empDetails.put("1",new EmployeeDetails("Sakthi","1","SQL developer"));
		empDetails.put("2",new EmployeeDetails("Somu","2","Python eveloper"));
		empDetails.put("3",new EmployeeDetails("Rexon","3","Frontend developer"));
		empDetails.put("4",new EmployeeDetails("Aravind","4","Backend developer"));
//		return "Welcome to the database"+"\n"+"Which user you want?";
		return "Hello world";
	}

	public EmployeeDetails Employee(String EmpId){
		EmployeeDetails empDetail=new EmployeeDetails();
		HashMap<String,EmployeeDetails> empDetails=getEmpDetails();
		empDetail=empDetails.get(EmpId);
		return empDetail;
	}
	
	public HashMap<String,EmployeeDetails> getEmpDetails(){
		return empDetails;
	}
	
	public HashMap<String,EmployeeDetails> addEmployee(EmployeeDetails Emp){
		empDetails.put(Emp.getEmpId(),Emp);
		return empDetails;
	}
	
	public HashMap<String,EmployeeDetails> deleteEmployee(EmployeeDetails Emp){
		empDetails.remove(Emp.getEmpId());
		return empDetails;
	}
	
}