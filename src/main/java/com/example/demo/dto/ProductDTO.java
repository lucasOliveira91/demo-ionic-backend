package com.example.demo.dto;

import com.example.demo.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 20/11/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String name;
    private Double price;

    public ProductDTO(Product obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
    }
}
