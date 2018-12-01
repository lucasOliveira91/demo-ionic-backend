package com.example.demo.service;

import com.example.demo.domain.Custumer;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.CustumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by loliveira on 01/12/18.
 */
@Service
public class AuthService {

    @Autowired
    private CustumerRepository custumerRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    public void sendNewPassword(String email) {
        Custumer custumer = custumerRepository.findByEmail(email);

        if(custumer == null) {
            throw new ObjectNotFoundException("E-mail doesn't exist.");
        }

        String newPass = newPassword();
        custumer.setPassword(pe.encode(newPass));
        custumerRepository.save(custumer);
        emailService.sendNewPasswordEmail   (custumer, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i < 10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        Random random = new Random();
        int opt = random.nextInt(3);

        if(opt == 0) { //generate digit
            return (char)(random.nextInt(10) + 48);
        }else if(opt == 1) {//generate lowercase letter
            return (char)(random.nextInt(26) + 65);
        }else {//geanrate upercase letter
            return (char)(random.nextInt(26) + 97);
        }

    }
}
