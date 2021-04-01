package com.ibm.mail.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mail.service.MailService;

@RestController
public class MailController {
	@Autowired
	MailService mailService;

	@GetMapping("/mail")
	int sendMail(@PathParam("to") String mailId) {
		return mailService.sendMail(mailId);
	}

	@GetMapping("/getTaxes")
	float calculateTaxes(@PathParam("price") float price) {
		return price * 0.3F;
	}

}
