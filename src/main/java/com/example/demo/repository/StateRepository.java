package com.example.demo.repository;

import com.example.demo.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
