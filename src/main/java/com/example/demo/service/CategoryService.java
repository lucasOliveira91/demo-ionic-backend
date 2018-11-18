package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.exception.DataIntegrityException;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 16/11/18.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category find(Integer id) {
        return repository.findById(id).orElseThrow(() ->
            new ObjectNotFoundException("Objeto não encontrado! Id:" + id + " " + Category.class.getName()));
    }

    public Category insert(Category obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Category update(Category obj) {
        find(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        find(id);

        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityException("we cannot delete, there're relation with products.");
        }
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Page<Category> findAllPageable(Integer page, Integer linesPerPage, String orderBy, String direction  ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
