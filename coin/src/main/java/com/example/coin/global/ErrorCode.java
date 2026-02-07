package com.example.coin.global;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "없는 전화번호 입니다. 회원가입을 진행하세요."),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "없는 방 번호 입니다."),
    LACK_OF_SONG_COUNT(HttpStatus.BAD_REQUEST, "사용할 곡 수가 잔여 곡 수보다 큽니다."),
    DUPLICATE_PHONE(HttpStatus.CONFLICT, "동일한 전화번호의 회원정보가 존재합니다."),
    INVALID_ROOM_STATUS(HttpStatus.BAD_REQUEST, "입력된 방 상태가 올바르지 않습니다."),
    ROOM_UNAVAILABLE(HttpStatus.CONFLICT, "이용할 수 없는 방입니다. 다른 방을 선택해주세요.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}

