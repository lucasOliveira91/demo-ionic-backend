package com.example.demo.resource.swagger;

import com.example.demo.domain.Category;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

/**
 * Created by loliveira on 06/01/19.
 */
public interface CategorySwagger {

    @ApiOperation("Return the category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
            @ApiResponse(code = 404, message = "Código inexistente") })
    ResponseEntity<Category> find(Integer id);

}
