package com.example.demo.service.validation;

import com.example.demo.domain.Custumer;
import com.example.demo.domain.enums.CustumerType;
import com.example.demo.dto.CustumerDTO;
import com.example.demo.dto.CustumerNewDTO;
import com.example.demo.repository.CustumerRepository;
import com.example.demo.resource.exception.FieldMessage;
import com.example.demo.service.validation.utils.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by loliveira on 20/11/18.
 */
public class CustumerUpdateValidator implements ConstraintValidator<CustumerUpdate, CustumerDTO> {

    @Autowired
    CustumerRepository custumerRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(CustumerUpdate ann) {
    }

    @Override
    public boolean isValid(CustumerDTO type, ConstraintValidatorContext context) {
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));
        List<FieldMessage> list = new ArrayList<>();

        Custumer byEmail = custumerRepository.findByEmail(type.getEmail());
        if(byEmail != null && !uriId.equals(type.getId())) {
            list.add(new FieldMessage("email","email already exists."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}

