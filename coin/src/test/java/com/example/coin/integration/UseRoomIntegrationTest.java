package com.example.coin.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UseRoomIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 회원_곡사용_방입장_전체흐름_성공() throws Exception {

        // 초기 회원: 010-1234-5678, songCount = 0

        // 1) 곡을 5개 추가
        mockMvc.perform(patch("/members/010-1234-5678/songs?count=5"))
                .andExpect(status().isOk());

        // 2) 곡 3개 사용 + 방 1번 입장
        mockMvc.perform(patch("/members/010-1234-5678/use?count=3&roomnum=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songCount").value(2))
                .andExpect(jsonPath("$.status").value("USING"))
                .andExpect(jsonPath("$.roomNumber").value(1));
    }
}
