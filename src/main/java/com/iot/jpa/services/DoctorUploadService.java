package com.iot.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iot.jpa.Entities.Doctor;
import com.iot.jpa.dao.DoctorRepository;

@Service
public class DoctorUploadService {
	@Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    // Fetch patient by email
    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }
}
