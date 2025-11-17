package com.example.coin.domain;

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

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
