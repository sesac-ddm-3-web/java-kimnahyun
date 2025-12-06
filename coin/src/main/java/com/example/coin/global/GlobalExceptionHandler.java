package com.example.coin.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                exception.getStatus()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        return new ResponseEntity<>("이름과 전화번호의 입력 방식이 올바르지 않습니다.", HttpStatus.BAD_REQUEST);
    }

}
