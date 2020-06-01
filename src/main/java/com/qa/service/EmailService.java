package com.qa.service;

import com.qa.domain.Booking;
import com.qa.domain.Email;
import com.qa.dto.BookingDTO;
import com.qa.dto.EmailDTO;
import com.qa.repo.BookingRepository;
import com.qa.repo.EmailRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {

    private final EmailRepo repo;

    private final Mapper<Email, EmailDTO> mapper;

    @Autowired
    public EmailService(EmailRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = (Email email) -> mapper.map(email, EmailDTO.class);
    }

    public EmailDTO sendmail(Email email) throws MessagingException {


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");



        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("qacinema.jobs@gmail.com", "QACinemaProject1234");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("temiloluwaw@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("qacinema.jobs@gmail.com"));
        msg.setSubject("Feedback: " + email.getSubject());
//        msg.setContent("This feedback email was sent by " + username + " and it says" + body + " and their contact email is" + email, "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setContent("This feedback email was sent by " + email.getUsername(), "text/html");

        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        messageBodyPart2.setContent(". The feedback says " + email.getBody(), "text/html");

        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        messageBodyPart3.setContent("Their return contact info is " + email.getEmail(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        msg.setContent(multipart);
        Transport.send(msg);
        return this.mapper.mapToDTO(this.repo.save(email));
//        return "Email Sent";
    }

}
