package com.cargocompare.CargoCompare_api.commons.config;


import com.cargocompare.CargoCompare_api.commons.constants.ErrorApiResponse;
import com.cargocompare.CargoCompare_api.companies.exceptions.CreatingCompanyError;
import com.cargocompare.CargoCompare_api.suppliers.exceptions.CreatingSupplierError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import lombok.extern.slf4j.Slf4j;

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

    @ExceptionHandler(CreatingSupplierError.class)
    public ResponseEntity<ErrorApiResponse> handleCreatingSupplierError(CreatingSupplierError e) {
        var errorResponse = ErrorApiResponse.builder()
                .message("Creating Supplier Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        log.error("New Exception:", e.getMessage());

        return ResponseEntity.status(409).body(errorResponse);
    }


}
