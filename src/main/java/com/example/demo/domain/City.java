package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by loliveira on 16/11/18.
 */
@Entity
@Data
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
