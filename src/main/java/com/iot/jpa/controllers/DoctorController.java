package com.iot.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iot.jpa.Entities.Doctor;
import com.iot.jpa.services.DoctorUploadService;
@Controller
public class DoctorController {
	@Autowired
    private DoctorUploadService doctorUploadService;
	
	@PostMapping("/doctor-register")
    public String registerPatient(@ModelAttribute Doctor doctor) {
        doctorUploadService.saveDoctor(doctor);
        return "redirect:/login-doctor";
    }
	
	@GetMapping("/login-doctor")
	public String loginDoctor() {
		return "doctorLogin";
	}
	@GetMapping("/homed")
	public String homed() {
	    return "homed"; // Loads home.html
	}
	@GetMapping("/logoutd")
	public String logoutd() {
	    return "website"; // Loads home.html
	}
    @PostMapping("/doctor-login")
    public String loginD(@RequestParam String email, @RequestParam String password) {
        // Check if email and password match with data in the database
        Doctor doctor = doctorUploadService.findDoctorByEmail(email);

        if (doctor != null && doctor.getPassword().equals(password)) {
            // If credentials are correct, redirect to home page
            return "redirect:/homed";
        } else {
            return "redirect:/login-doctor";
        }
    }
    
    
}
