package com.example.demo.repository;

import com.example.demo.domain.Custumer;
import com.example.demo.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Transactional(readOnly = true)
    Page<Order> findByCustumer(Custumer custumer, Pageable pageable);
}
