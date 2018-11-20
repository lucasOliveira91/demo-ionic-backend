package com.example.demo.repository;

import com.example.demo.domain.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface CustumerRepository extends JpaRepository<Custumer, Integer> {

    @Transactional(readOnly = true)
    Custumer findByEmail(String email);
}
