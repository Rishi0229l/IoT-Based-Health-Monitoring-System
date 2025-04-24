package com.iot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iot.jpa.Entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Doctor findByEmail(String email);
}
