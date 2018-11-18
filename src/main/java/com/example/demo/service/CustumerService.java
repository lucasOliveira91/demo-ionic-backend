package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Custumer;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CustumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by loliveira on 16/11/18.
 */
@Service
public class CustumerService {

    @Autowired
    private CustumerRepository custumerRepository;

    public Custumer find(Integer id) {
        return custumerRepository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id:" + id + " " + Category.class.getName()));
    }

}
