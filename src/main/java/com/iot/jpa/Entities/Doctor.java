package com.iot.jpa.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Doctor {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    
    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    private LocalDate dob;

    private String gender;

    private String specialization;

    @Column(unique = true)
    private String licenseNumber;

    private String clinicName;

    @Column(length = 500)
    private String address;

    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Doctor(Long id, String fullName, String email, String phoneNumber, LocalDate dob, String gender,
			String specialization, String licenseNumber, String clinicName, String address, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.gender = gender;
		this.specialization = specialization;
		this.licenseNumber = licenseNumber;
		this.clinicName = clinicName;
		this.address = address;
		this.password = password;
	}

	public Doctor() {
		super();
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", dob=" + dob + ", gender=" + gender + ", specialization=" + specialization + ", licenseNumber="
				+ licenseNumber + ", clinicName=" + clinicName + ", address=" + address + ", password=" + password
				+ "]";
	}
	
}

