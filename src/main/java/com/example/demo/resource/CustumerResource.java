package com.example.demo.resource;

import com.example.demo.service.CategoryService;
import com.example.demo.service.CustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by loliveira on 16/11/18.
 */
@RestController
@RequestMapping("/custumer")
public class CustumerResource {

    @Autowired
    private CustumerService custumerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(custumerService.find(id));
    }
}
