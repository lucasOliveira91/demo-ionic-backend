package com.example.demo.repository;

import com.example.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
