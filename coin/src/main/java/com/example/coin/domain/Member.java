package com.example.coin.domain;

import java.util.concurrent.atomic.AtomicLong;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
