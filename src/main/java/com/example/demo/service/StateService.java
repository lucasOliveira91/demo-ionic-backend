package com.example.demo.service;

import com.example.demo.domain.State;
import com.example.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 02/12/18.
 */
@Service
public class StateService {

    @Autowired
    private StateRepository stateRespository;

    public List<State> findAll() {
        return stateRespository.findAllByOrderByName();
    }
}
