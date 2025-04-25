package com.iot.jpa.controllers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.jpa.Entities.Patient;
import com.iot.jpa.dao.PatientRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
public class FeedbackController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Load feedback page with patient dropdown
    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "feedback";
    }

    // Send feedback via email
    @PostMapping("/send-feedback")
    @ResponseBody
    public String sendFeedback(
            @RequestParam("email") String patientEmail,
            @RequestParam(value = "subject", required = false) String subject,
            @RequestParam(value = "dateOfVisit", required = false) String dateOfVisit,
            @RequestParam("message") String message
    ) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
            helper.setTo(patientEmail);
            helper.setSubject(subject != null && !subject.isBlank() ? subject : "Doctor's Feedback");

            String htmlMsg = "<h3>Feedback from your Doctor</h3>" +
                    "<p><strong>Date of Visit:</strong> " + (dateOfVisit != null ? dateOfVisit : "N/A") + "</p>" +
                    "<p><strong>Message:</strong></p>" +
                    "<p>" + message + "</p>";

            helper.setText(htmlMsg, true); // Enable HTML

            mailSender.send(mimeMessage);

            return "Feedback sent successfully to " + patientEmail;

        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send feedback. Please try again.";
        }
    }
}
