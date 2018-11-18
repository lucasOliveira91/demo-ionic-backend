package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by loliveira on 17/11/18.
 */
@Data
@Entity
@Table(name = "orderx")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "custumer_id")
    private Custumer custumer;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    Set<OrderItem> items = new HashSet<>();

}
