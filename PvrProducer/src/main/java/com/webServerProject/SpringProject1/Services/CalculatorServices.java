package com.webServerProject.SpringProject1.Services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServices {
	public String getResponse(){
		return "Basic Calculator"+"\n"+"Which operation you want?";
	}
	public int Calculator(String Operation,int a,int b) {
		int result=0;
		switch (Operation) {
		case "Add":result=a+b;break;
		case "Sub":result=a-b;break;
		case "Mul":result=a*b;break;
		case "Div":result=a/b;break;
	    }
		return result;
	}
}