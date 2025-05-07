package com.iot.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.jpa.Entities.Patient;
import com.iot.jpa.dao.PatientRepository;

@Service
public class PatientUploadService {
	
	@Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    // Fetch patient by email
    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }
    
    
}
