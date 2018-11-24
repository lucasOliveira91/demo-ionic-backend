package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by loliveira on 18/11/18.
 */
@Getter
@Setter
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

    public double getSubTotal() {
        return (price - descont) * amount;
    }

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

    public void setProduct(Product product) {
        if(id == null)
            id = new OrderItemPK();
        id.setProduct(product);
    }

    public void setOrder(Order order) {
        if(id == null)
            id = new OrderItemPK();
        id.setOrder(order);
    }
    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    @Override
    public String toString() {
        NumberFormat nf =   NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

        StringBuilder str = new StringBuilder();
        str.append(getProduct().getName());
        str.append(", Amount: ");
        str.append(nf.format(price));
        str.append(", Subtotal: ");
        str.append(nf.format(getSubTotal()));
        str.append("\n");
        return str.toString();
    }
}
