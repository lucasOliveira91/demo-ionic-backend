package com.example.demo.dto;

import com.example.demo.domain.City;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 02/12/18.
 */
@Data
@NoArgsConstructor
public class CityDTO {

    private Integer id;
    private String name;

    public CityDTO(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }
}
