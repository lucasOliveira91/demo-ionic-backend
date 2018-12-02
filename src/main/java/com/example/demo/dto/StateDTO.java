package com.example.demo.dto;

import com.example.demo.domain.State;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 02/12/18.
 */
@Data
@NoArgsConstructor
public class StateDTO {

    private Integer id;
    private String name;

    public StateDTO(State state) {
        this.id = state.getId();
        this.name = state.getName();
    }
}
