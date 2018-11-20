package com.example.demo.dto;

import com.example.demo.service.validation.CustumerInsert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by loliveira on 19/11/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@CustumerInsert
public class CustumerNewDTO {

    @NotEmpty(message = "Required")
    @Length(min = 5, message = "at least 5 caracters")
    private String name;

    @NotEmpty(message = "Required")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Required")
    private String cpfCnpj;
    private Integer custumerType;

    @NotEmpty(message = "Required")

    private String publicPlace;
    private String neighborhood;
    private String complement;

    @NotEmpty(message = "Required")
    private String number;

    @NotEmpty(message = "Required")
    private String zipCOde;

    @NotEmpty(message = "Required")
    private String celPhone1;
    private String celPhone2;
    private String celPhone3;

    private Integer cityId;
}
