package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by loliveira on 16/11/18.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @Query("SELECT distinct obj " +
//            "FROM PRODUCT obj INNER JOIN obj.categories cat " +
//            "WHERE obj.name like %:name% AND cat IN :categories")
//    Page<Product> search(@Param("name") String name, @Param("categories") List<Category> categories, Pageable pageRequest);

    @Transactional(readOnly = true)
    Page<Product> findDistinctByNameContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageable);
}
