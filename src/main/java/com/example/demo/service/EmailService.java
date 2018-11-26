package com.example.demo.service;

import com.example.demo.domain.Order;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

/**
 * Created by loliveira on 24/11/18.
 */
public interface EmailService {

    void OrderConfirmationEmail(Order order);
    void sendEmail(SimpleMailMessage msg);

    void OrderConfirmationEmailHtml(Order order);
    void sendEmailHtml(MimeMessage msg);
}
