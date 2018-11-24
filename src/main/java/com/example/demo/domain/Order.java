package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by loliveira on 17/11/18.
 */
@Getter
@Setter
@Entity
@Table(name = "orderx")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "custumer_id")
    private Custumer custumer;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @OneToMany(mappedBy = "id.order")
    Set<OrderItem> items = new HashSet<>();


    public double getTotal() {
        double total = 0.0;
        for (OrderItem item: items){
            total += item.getSubTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        NumberFormat nf =   NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

       StringBuilder str = new StringBuilder();
        str.append("Order number: ");
        str.append(getId());
        str.append(", Instant: ");
        str.append(sdf.format(getInstant()));
        str.append(", Cliente: ");
        str.append(getCustumer().getName());
        str.append(", Payment status: ");
        str.append(getPayment().getPayStatus());
        str.append("\nDetails\n");

        for (OrderItem item : getItems()) {
             str.append(item.toString());
        }

        str.append("Total:");
        str.append(nf.format(getTotal()));
        return str.toString();
    }
}
