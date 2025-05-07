package com.iot.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class generalController {
	
	
	@GetMapping("/graph")
    public String index() {
        return "index"; // // patient view
    }
    
    @GetMapping("/graph2")
    public String index2() {
        return "index2"; // doctor view
    }
    
	@GetMapping("/basic")
	public String viewGeneralPage() {
	    return "general"; // patient view
	}
	
	@GetMapping("/basic2")
	public String viewGeneralPage2() {
	    return "general2"; // doctor view
	}
	
	@GetMapping("/")
	public String home() {
	    return "website"; // Loads home.html
	}
	
	
	@GetMapping("/logoutp")
	public String logoutp() {
	    return "website"; // Loads home for patient
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
	public String registerD() {
	    return "doctorRegistration";
	}
	
	@GetMapping("/signup")
	public String registerP() {
	    return "patientRegistration";
	}
	
	@GetMapping("/website")
	public String websitehome() {
	    return "website";    // home page if not logged in
	}
	
	// table data 
	@GetMapping("/view-table")
	public String table() {
	    return "table";    //doctor view
	}
	
	@GetMapping("/view-table2")
	public String table2p() {
	    return "table2p";     // patient view
	}
	
}
