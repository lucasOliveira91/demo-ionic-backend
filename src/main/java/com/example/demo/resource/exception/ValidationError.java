package com.example.demo.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loliveira on 16/11/18.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public void AddError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
