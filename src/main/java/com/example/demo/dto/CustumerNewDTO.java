package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 19/11/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustumerNewDTO {

    private String name;
    private String email;
    private String cpfCnpj;
    private Integer custumerType;

    private String publicPlace;
    private String neighborhood;
    private String complement;
    private String number;
    private String zipCOde;

    private String celPhone1;
    private String celPhone2;
    private String celPhone3;

    private Integer cityId;
}
