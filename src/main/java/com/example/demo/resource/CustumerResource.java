package com.example.demo.resource;

import com.example.demo.domain.Custumer;
import com.example.demo.dto.CustumerDTO;
import com.example.demo.dto.CustumerNewDTO;
import com.example.demo.service.CustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustumerNewDTO obj) {
        Custumer objx = custumerService.fromDTO(obj);

        custumerService.insert(objx);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objx.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CustumerDTO obj, @PathVariable Integer id) {
        obj.setId(id);
        custumerService.update(obj);
        return  ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        custumerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/page")
    public ResponseEntity<Page<CustumerDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                      @RequestParam(value = "direction", defaultValue = "ASC") String direction ) {
        Page<Custumer> list = custumerService.findAllPageable(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list.map(obj -> new CustumerDTO(obj)));
    }
}
