package com.example.demo.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by loliveira on 16/11/18.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessage {

    private String fieldName;
    private String message;
}
