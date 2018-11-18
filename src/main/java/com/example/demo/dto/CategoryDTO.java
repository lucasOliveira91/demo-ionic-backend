package com.example.demo.dto;

import com.example.demo.domain.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * Created by loliveira on 18/11/18.
 */
@Data
@NoArgsConstructor
public class CategoryDTO {

    private Integer id;

    @NotEmpty(message = "required")
    @Length(min = 5, max = 80, message = "The lenght should be between 5 and 80 caracters.")
    private String name;

    public CategoryDTO (Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public static Category toEntity(CategoryDTO dto) {
        Category c = new Category();
        c.setId(dto.getId());
        c.setName(dto.getName());

        return c;
    }
}
