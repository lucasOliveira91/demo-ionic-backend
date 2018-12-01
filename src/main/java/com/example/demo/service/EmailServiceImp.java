package com.example.demo.service;

import com.example.demo.domain.Custumer;
import com.example.demo.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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
    TemplateEngine templateEngine;

    @Autowired
    JavaMailSender javaMailSender;

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

    protected String htmlFromTemplate(Order order){
        Context context = new Context();
        context.setVariable("order", order);
        //For default, thymeleaf get the templates from folder "resources/templates/"
        //it isn't need put .html in url
        return templateEngine.process("email/emailCofirmation",context);
    }

    @Override
    public void OrderConfirmationEmailHtml(Order order) {
        MimeMessage mm = null;
        try {
            mm = preparMimeMessageFromPedido(order);
            sendEmailHtml(mm);
        } catch (MessagingException e) {
            OrderConfirmationEmail(order);
        }
    }

    private MimeMessage preparMimeMessageFromPedido(Order order) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
//        mmh.setTo(order.getCustumer().getEmail());
        mmh.setTo("lukys.taylor@gmail.com");
        mmh.setFrom(this.sender);
        mmh.setSubject("Confirmation");
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplate(order),true);
        return mimeMessage;
    }

    @Override
    public void sendEmailHtml(MimeMessage msg) {
        log.info("Sending email... to: ");
        javaMailSender.send(msg);
        log.info("Email sent.");
    }

    @Override
    public void sendNewPasswordEmail(Custumer custumer, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(custumer, newPass);
        sendEmail(sm);
    }

    private SimpleMailMessage prepareNewPasswordEmail(Custumer custumer, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
//        sm.setTo(order.getCustumer().getEmail());
        sm.setTo("lukys.taylor@gmail.com");
        sm.setFrom(sender);
        sm.setSubject("New Email    ");
        sm.setSentDate(new Date(System.currentTimeMillis())); //To take care, that will create the date based from server
        sm.setText("new pass: " + newPass);
        return sm;
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
