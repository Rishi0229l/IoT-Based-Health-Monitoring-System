package com.iot.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class generalController {
    
	@GetMapping("/basic")
	public String viewGeneralPage() {
	    return "general"; // Loads templates/general.html
	}
	
	@GetMapping("/basic2")
	public String viewGeneralPage2() {
	    return "general2"; // Loads templates/general.html
	}
	
	@GetMapping("/")
	public String home() {
	    return "website"; // Loads home.html
	}
	
	@GetMapping("/homep")
	public String homep() {
	    return "homep"; // Loads home.html
	}
	@GetMapping("/logoutp")
	public String logoutp() {
	    return "website"; // Loads home.html
	}
	
	@GetMapping("/login-selection")
	public String loginSelect() {
	    return "loginType"; 
	}
	
	@GetMapping("/login-patient")
	public String loginP() {
	    return "patientLogin"; 
	}
	

	@GetMapping("/doctor-signup")
	public String registerP() {
	    return "doctorRegistration";
	}
	
	@GetMapping("/signup")
	public String registerD() {
	    return "patientRegistration";
	}
	
	@GetMapping("/website")
	public String websitehome() {
	    return "website";
	}
	
	// Feedback management
//	@GetMapping("/feedback")
//	public String feedback() {
//	    return "feedback";
//	}
}
