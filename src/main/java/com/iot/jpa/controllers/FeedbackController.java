package com.iot.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.iot.jpa.Entities.Patient;
import com.iot.jpa.dao.PatientRepository;

@Controller
public class FeedbackController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Show form
    @GetMapping("/feedback/{patientId}")
    public String showForm(@PathVariable Long patientId, Model model) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        model.addAttribute("patient", patient);
        return "feedback";
    }

    // Handle form
    @PostMapping("/send-feedback")
    @ResponseBody
    public ResponseEntity<String> sendFeedback(
        @RequestParam Long patientId,
        @RequestParam String message,
        @RequestParam(required = false) String subject,
        @RequestParam(required = false) String dateOfVisit) {

        Patient patient = patientRepository.findById(patientId).orElseThrow();

        String emailSubject = (subject == null || subject.isBlank()) ? "Doctor's Feedback" : subject;
        String fullMessage = "Date of Visit: " + (dateOfVisit != null ? dateOfVisit : "N/A") + "\n\n" + message;

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(patient.getEmail());
            mail.setSubject(emailSubject);
            mail.setText(fullMessage);
            mailSender.send(mail);
            return ResponseEntity.ok("Feedback sent");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Email failed");
        }
    }
}

