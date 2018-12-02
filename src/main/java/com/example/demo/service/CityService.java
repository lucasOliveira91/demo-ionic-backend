package com.example.demo.service;

import com.example.demo.domain.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 02/12/18.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findCities(Integer stateId){
        return cityRepository.findCities(stateId);
    }
}
