package com.example.demo.domain;

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
public class Order {

    private Integer id;
    private Date instant;
    private Payment payment;
    private Custumer custumer;
    private Address deliveryAddress;

}
