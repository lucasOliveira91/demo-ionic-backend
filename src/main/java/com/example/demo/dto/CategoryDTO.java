package com.example.demo.dto;

import com.example.demo.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 18/11/18.
 */
@Data
@NoArgsConstructor
public class CategoryDTO {

    private Integer id;
    private String name;

    public CategoryDTO (Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
