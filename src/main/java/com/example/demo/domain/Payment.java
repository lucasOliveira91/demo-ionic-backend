package com.example.demo.domain;

import com.example.demo.domain.enums.PayStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by loliveira on 17/11/18.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer id;
    private PayStatus payStatus;
    private Order order;
}
