package com.example.demo.dto;

import com.example.demo.domain.Custumer;
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
public class CustumerDTO {

    private Integer id;

    @NotEmpty(message = "Required")
    @Length(min = 5, message = "at least 5 caracters")
    private String name;

    @NotEmpty
    @Email(message = "Invalid email")
    private String email;

    public CustumerDTO(Custumer custumer){
        this.id = custumer.getId();
        this.name = custumer.getName();
        this.email = custumer.getName();
    }

}
