package com.example.demo.resource;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Created by loliveira on 16/11/18.
 */
@RestController
@RequestMapping("/order")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(orderService.find(id));
    }

    @PostMapping
        public ResponseEntity<Void> insert(@Valid @RequestBody Order obj) {
        orderService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<Order>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                      @RequestParam(value = "orderBy", defaultValue = "instant") String orderBy,
                                                      @RequestParam(value = "direction", defaultValue = "DESC") String direction ) {
        Page<Order> list = orderService.findAllPageable(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

}
