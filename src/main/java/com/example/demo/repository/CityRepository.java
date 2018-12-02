package com.example.demo.repository;

import com.example.demo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM City obj WHERE " +
            "obj.state.id = :stateId order by obj.name")
    List<City> findCities(@Param("stateId") Integer stateId);
}
