package com.example.coin.presentation;

import com.example.coin.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundMemberException.class)
    public ResponseEntity<String> handleNotFoundMemberException(
            NotFoundMemberException exception
    ) {
        return new ResponseEntity<>("없는 전화번호 입니다. 회원가입을 진행하세요.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundRoomException.class)
    public ResponseEntity<String> handleNotFoundRoomException(
            NotFoundRoomException exception
    ) {
        return new ResponseEntity<>("없는 방 번호 입니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LackOfSongCountException.class)
    public ResponseEntity<String> handleLackOfSongCountException(
            LackOfSongCountException exception
    ) {
        return new ResponseEntity<>("사용할 곡 수가 잔여 곡 수보다 큽니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicatePhoneException.class)
    public ResponseEntity<String> handleDuplicatePhoneException(
            DuplicatePhoneException exception
    ) {
        return new ResponseEntity<>("동일한 전화번호의 회원정보가 존재합니다.", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidRoomStatusException.class)
    public ResponseEntity<String> handleInvalidRoomStatusException(
            InvalidRoomStatusException exception
    ) {
        return new ResponseEntity<>("입력된 방 상태가 올바르지 않습니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoomUnavailableException.class)
    public ResponseEntity<String> handleRoomUnavailableException(
            RoomUnavailableException exception
    ) {
        return new ResponseEntity<>("이용할 수 없는 방입니다. 다른 방을 선택해주세요.", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        return new ResponseEntity<>("이름과 전화번호의 입력 방식이 올바르지 않습니다.", HttpStatus.BAD_REQUEST);
    }

}
