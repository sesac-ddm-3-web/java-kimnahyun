package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Member {
    private static final AtomicLong sequence = new AtomicLong(0L);

    Long id;
    String name;
    String phoneNumber;
    int songCount;

    public Member(String name, String phoneNumber) {
        this.id = sequence.incrementAndGet();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.songCount = 0;
    }

    public void addSongCount(int count) {
        this.songCount += count;
    }

    public void useSongCount(int count) {
        if (this.songCount < count) {
            throw new BusinessException(ErrorCode.LACK_OF_SONG_COUNT);
        }
        this.songCount -= count;
    }
}
