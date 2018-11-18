package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by loliveira on 15/11/18.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY",
                joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    Set<OrderItem> items = new HashSet<>();

    List<Order> orders = new ArrayList<>();

    public List<Order> getOrders () {
        List<Order> list = new ArrayList<>();
        for(OrderItem item: items) {
            list.add(item.getOrder());
        }

        return list;
    }
}
