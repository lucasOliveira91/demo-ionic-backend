package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Order;
import com.example.demo.domain.Product;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by loliveira on 16/11/18.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order find(Integer id) {
        return orderRepository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id:" + id + " " + Category.class.getName()));
    }

}
