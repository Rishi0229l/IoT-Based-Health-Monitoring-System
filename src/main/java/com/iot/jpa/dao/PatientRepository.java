package com.iot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.jpa.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // optional: add custom queries here
	
	Patient findByEmail(String email);
}
