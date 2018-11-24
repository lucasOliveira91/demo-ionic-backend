package com.example.demo.service;

import com.example.demo.domain.CreditCardPayment;
import com.example.demo.domain.TicketPayment;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by loliveira on 21/11/18.
 */
@Service
public class TicketService {

    public void fillTicketPayment(CreditCardPayment pay, Date instant) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instant);
        cal.add(Calendar.DAY_OF_MONTH, 7);
//        pay.set(cal.getTime());
    }
}
