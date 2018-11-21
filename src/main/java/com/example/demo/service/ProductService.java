package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 16/11/18.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product find(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id:" + id + " " + Category.class.getName()));
    }

    public Page<Product> findAllPageable(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction  ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Category> categories = categoryRepository.findAllById(ids);

        return productRepository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
    }

}
