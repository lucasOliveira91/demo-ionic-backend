package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by loliveira on 18/11/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Double descont;
    private Integer amount;
    private Double price;

    public OrderItem(Order order, Product product, Double descont, Integer amount, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.descont = descont;
        this.amount = amount;
        this.price = price;
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }
}
