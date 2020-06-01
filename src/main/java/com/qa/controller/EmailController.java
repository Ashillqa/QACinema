package com.qa.controller;

import com.qa.domain.Email;
import com.qa.dto.BookingDTO;
import com.qa.dto.EmailDTO;
import com.qa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import java.io.IOException;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<EmailDTO> sendEmail(@RequestBody Email email) throws IOException, MessagingException {
        return new ResponseEntity<EmailDTO>(this.emailService.sendmail(email), HttpStatus.CREATED);
    }


}
