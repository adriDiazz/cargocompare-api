package com.cargocompare.CargoCompare_api.commons.config;


import com.cargocompare.CargoCompare_api.commons.constants.ErrorApiResponse;
import com.cargocompare.CargoCompare_api.companies.exceptions.CompanyNotFoundError;
import com.cargocompare.CargoCompare_api.companies.exceptions.CreatingCompanyError;
import com.cargocompare.CargoCompare_api.suppliers.exceptions.CreatingSupplierError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CreatingCompanyError.class)
    public ResponseEntity<ErrorApiResponse> handleCreatingCompanyError(CreatingCompanyError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message("Creating Company Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(409).body(errorResponse);
    }

    @ExceptionHandler(CompanyNotFoundError.class)
    public ResponseEntity<ErrorApiResponse> handleCompanyNotFoundError(CreatingCompanyError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message("Creating Company Error")
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(409).body(errorResponse);
    }

    @ExceptionHandler(CreatingSupplierError.class)
    public ResponseEntity<ErrorApiResponse> handleCreatingSupplierError(CreatingSupplierError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message("Creating Supplier Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(409).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.error("New Exception:", ex.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }


}
