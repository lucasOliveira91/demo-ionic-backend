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
public class StandardError {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
