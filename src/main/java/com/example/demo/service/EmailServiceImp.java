package com.example.demo.service;

import com.example.demo.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by loliveira on 24/11/18.
 */
@Profile("dev")
@Service
@Slf4j
public class EmailServiceImp implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private MailSender mailSender;

    public void OrderConfirmationEmail(Order order) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(order);
        sendEmail(sm);
    }

    public void sendEmail(SimpleMailMessage msg) {
        log.info("Sending email... to: " + msg.getTo());
        mailSender.send(msg);
        log.info("Email sent.");
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromOrder(Order order){
        SimpleMailMessage sm = new SimpleMailMessage();
//        sm.setTo(order.getCustumer().getEmail());
        sm.setTo("lukys.taylor@gmail.com");
        sm.setFrom(sender);
        sm.setSubject("Confirmation Order: "+order.getId());
        sm.setSentDate(new Date(System.currentTimeMillis())); //To take care, that will create the date based from server
        sm.setText(order.toString());
        return sm;
    }
}
