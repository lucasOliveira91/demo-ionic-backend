package com.example.demo.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by loliveira on 16/11/18.
 */
@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private String msg;
    private Long timeStamp;
}
