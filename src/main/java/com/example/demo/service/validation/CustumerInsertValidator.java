package com.example.demo.service.validation;

import com.example.demo.domain.enums.CustumerType;
import com.example.demo.dto.CustumerNewDTO;
import com.example.demo.resource.exception.FieldMessage;
import com.example.demo.service.validation.utils.B;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by loliveira on 20/11/18.
 */
public class CustumerInsertValidator implements ConstraintValidator<CustumerInsert, CustumerNewDTO> {

    @Override
    public void initialize(CustumerInsert ann) {
    }

    @Override
    public boolean isValid(CustumerNewDTO type, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        //add your code validation
        if(type.getCustumerType().equals(CustumerType.PESSOA_FISICA.getId()) && !B.isValidCPF(type.getCpfCnpj())){
            list.add(new FieldMessage("cpf","Invalid number"));
        }

        if(type.getCustumerType().equals(CustumerType.PESSOA_JURIDICA.getId()) && !B.isValidCPF(type.getCpfCnpj())){
            list.add(new FieldMessage("cnpj","Invalid number"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}

