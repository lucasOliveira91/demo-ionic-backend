package com.example.demo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by loliveira on 17/11/18.
 */
@Getter
@AllArgsConstructor
public enum Role {

    ADMIN(1, "ROLE_ADMIN"), //the word Role is required for spring security
    CUSTUMER(2, "ROLE_CUSTUMER");

    private Integer id;
    private String description;

    public static Role toEnum(Integer code) {
        if(code == null) {
            return null;
        }

        for(Role type : Role.values()) {
            if(code.equals(type.getId())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}
