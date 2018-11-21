package com.example.demo.resource;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.resource.utils.URL;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by loliveira on 16/11/18.
 */
@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productService.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "categories", defaultValue = "") String categories,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction ) {
        Page<Product> list = productService.findAllPageable(
                URL.decodeParam(name),
                URL.decodeIntList(categories),
                page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list.map(obj -> new ProductDTO(obj)));
    }
}
