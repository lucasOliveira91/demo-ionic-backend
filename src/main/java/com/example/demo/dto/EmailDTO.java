package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by loliveira on 01/12/18.
 */
@Data
public class EmailDTO {

    @NotEmpty(message = "Required")
    @Email(message = "Email invalid")
    private String email;
}
