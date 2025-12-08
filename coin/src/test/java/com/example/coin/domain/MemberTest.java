package com.example.coin.domain;

import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberTest {

    @Test
    void 회원생성시_기본곡수는_0이다() {
        Member m = new Member("홍길동", "010-1234-5678");

        assertThat(m.getName()).isEqualTo("홍길동");
        assertThat(m.getPhoneNumber()).isEqualTo("010-1234-5678");
        assertThat(m.getSongCount()).isEqualTo(0);
    }

    @Test
    void 곡수_추가_성공() {
        Member m = new Member("홍길동", "010-1234-5678");

        m.addSongCount(5);

        assertThat(m.getSongCount()).isEqualTo(5);
    }

    @Test
    void 곡수_사용_성공() {
        Member m = new Member("홍길동", "010-1234-5678");
        m.addSongCount(7);

        m.useSongCount(3);

        assertThat(m.getSongCount()).isEqualTo(4);
    }

    @Test
    void 곡이_부족하면_예외() {
        Member m = new Member("홍길동", "010-1234-5678");
        m.addSongCount(2);

        BusinessException ex = assertThrows(
                BusinessException.class,
                () -> m.useSongCount(5)
        );

        assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.LACK_OF_SONG_COUNT);
    }
}
