package com.example.demo.domain;

import com.example.demo.domain.enums.PayStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by loliveira on 17/11/18.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("ticketPayment")
public class TicketPayment extends Payment{

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDate;

    public TicketPayment(Integer id, PayStatus payStatus, Order order, Date dueDate, Date paymentDate) {
        super(id, payStatus, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }


}
