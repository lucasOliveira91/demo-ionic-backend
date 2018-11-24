package com.example.demo.domain;

import com.example.demo.domain.enums.PayStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by loliveira on 17/11/18.
 */
@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
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
