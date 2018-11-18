package com.example.demo.domain;

import com.example.demo.domain.enums.PayStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by loliveira on 17/11/18.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id
    private Integer id;
    private Integer payStatus;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public Payment(Integer id, PayStatus payStatus, Order order) {
        this.id = id;
        this.payStatus = payStatus.getId();
        this.order = order;
    }
}
