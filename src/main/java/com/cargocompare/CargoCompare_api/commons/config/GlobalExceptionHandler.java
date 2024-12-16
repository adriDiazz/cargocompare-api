package com.cargocompare.CargoCompare_api.commons.config;


import com.cargocompare.CargoCompare_api.commons.constants.ErrorApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(ExistingGameError.class)
//    public ResponseEntity<ErrorApiResponse> handleExistingGameError(ExistingGameError e) {
//        var errorResponse = ErrorApiResponse.builder()
//                .message(e.getMessage())
//                .status(HttpStatus.CONFLICT.value())
//                .build();
//
//        log.error("New Exception:", e.getMessage());
//
//        return ResponseEntity.status(409).body(errorResponse);
//    }


}
