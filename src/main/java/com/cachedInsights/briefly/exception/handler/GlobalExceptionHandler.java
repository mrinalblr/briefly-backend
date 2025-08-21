package com.cachedInsights.briefly.exception.handler;

import com.cachedInsights.briefly.exception.AIClientAPIException;
import com.cachedInsights.briefly.model.response.errorResponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AIClientAPIException.class)
    public ResponseEntity<ErrorResponse> handleAIClientException(AIClientAPIException exception) {
            ErrorResponse errorResponse = ErrorResponse
                    .builder()
                    .timeStamp(Instant.now())
                    .errorMessage(exception.getMessage())
                    .build();

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
