package com.example.demo.resource;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by loliveira on 16/11/18.
 */
@RestController
@RequestMapping("/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> categories() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Category obj) {
        obj = categoryService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Category obj, @PathVariable Integer id) {
        obj.setId(id);
        categoryService.update(obj);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoryDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                      @RequestParam(value = "direction", defaultValue = "ASC") String direction ) {
        Page<Category> list = categoryService.findAllPageable(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list.map(obj -> new CategoryDTO(obj)));
    }
}
