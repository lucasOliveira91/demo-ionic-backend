package com.example.demo.service;

import com.example.demo.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by loliveira on 24/11/18.
 */
@Service
@Profile("test")
public class MockEmailServiceImp implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(MockEmailServiceImp.class);

    @Override
    public void OrderConfirmationEmail(Order order) {

    }

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        log.info("Email Simulation.");
        log.info(msg.toString());
        log.info("Email sent.   ");
    }

    @Override
    public void OrderConfirmationEmailHtml(Order order) {

    }

    @Override
    public void sendEmailHtml(MimeMessage msg) {
        log.info("Email HTML Simulation.");
        log.info(msg.toString());
        log.info("Email sent.   ");
    }
}
