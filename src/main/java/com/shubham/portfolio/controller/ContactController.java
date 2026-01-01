package com.shubham.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.portfolio.dto.ContactRequest;
import com.shubham.portfolio.service.EmailService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send-message")
	public String sendMessage(@Valid @RequestBody ContactRequest request) {
		System.out.println("Email received from form: " + request.getEmail());

		emailService.sendEmail(request.getName(), request.getEmail(), request.getMessage());

		return "Message sent successfully";
	}
}
