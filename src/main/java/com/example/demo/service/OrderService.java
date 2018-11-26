package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.domain.enums.PayStatus;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

/**
 * Created by loliveira on 16/11/18.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private CustumerService custumerService;

    @Autowired
    private EmailService emailService;

    public Order find(Integer id) {
        return orderRepository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id:" + id + " " + Category.class.getName()));
    }

    @Transactional
    public Order insert(@Valid Order obj) {
        obj.setId(null);
        obj.setInstant(new Date());
        obj.setCustumer(custumerService.find(obj.getCustumer().getId()));
        obj.getPayment().setPayStatus(PayStatus.PENDING.getId());
        obj.getPayment().setOrder(obj);

        if(obj.getPayment() instanceof CreditCardPayment) {
            CreditCardPayment pay = (CreditCardPayment) obj.getPayment();
            ticketService.fillTicketPayment(pay, obj.getInstant()   );
        }

        obj = orderRepository.save(obj);
        paymentRepository.save(obj.getPayment());

        for (OrderItem item: obj.getItems()) {
            item.setDescont(0d);
            Optional<Product> byId = productRepository.findById(1);
            item.setProduct(byId.get());
            item.setPrice(byId.get().getPrice());
            item.setOrder(obj);
        }

        itemRepository.saveAll(obj.getItems());
        emailService.OrderConfirmationEmailHtml(obj);
        return obj;
    }
}
