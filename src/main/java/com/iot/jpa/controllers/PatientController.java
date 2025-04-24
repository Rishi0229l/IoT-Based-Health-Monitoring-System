package com.iot.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iot.jpa.Entities.Patient;
import com.iot.jpa.services.PatientUploadService;


@Controller
public class PatientController {
	
	private String patientEmail="";

	@Autowired
    private PatientUploadService patientUploadService;

    @PostMapping("/patient-register")
    public String registerPatient(@ModelAttribute Patient patient) {
        patientUploadService.savePatient(patient);
        return "redirect:/login-patient";
    }
    
    @PostMapping("/loginP")
    public String loginP(@RequestParam String email, @RequestParam String password) {
        // Check if email and password match with data in the database
        Patient patient = patientUploadService.findPatientByEmail(email);

        if (patient != null && patient.getPassword().equals(password)) {
            // If credentials are correct, redirect to home page
        	patientEmail=email;
        	System.out.println(patientEmail);
            return "redirect:/homep";
        } else {
            return "redirect:/login-patient";
        }
    }
    
    
    public String getPatientEmail() {
		return patientEmail;
	}
}
