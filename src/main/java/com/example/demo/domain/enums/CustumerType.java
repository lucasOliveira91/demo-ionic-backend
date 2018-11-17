package com.example.demo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by loliveira on 17/11/18.
 */
@Getter
@AllArgsConstructor
public enum CustumerType {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private Integer id;
    private String description;

    public static CustumerType toEnum(Integer code) {
        if(code == null) {
            return null;
        }

        for(CustumerType type : CustumerType.values()) {
            if(code.equals(type.getId())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}
