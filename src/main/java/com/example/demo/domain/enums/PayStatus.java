package com.example.demo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by loliveira on 17/11/18.
 */
@Getter
@AllArgsConstructor
public enum PayStatus {

    PENDING(1, "Pending"),
    SETTLED(2, "Settled"),
    CANCELED(3, "Canceled");

    private Integer id;
    private String description;

    public static PayStatus toEnum(Integer code) {
        if(code == null) {
            return null;
        }

        for(PayStatus type : PayStatus.values()) {
            if(code.equals(type.getId())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}
