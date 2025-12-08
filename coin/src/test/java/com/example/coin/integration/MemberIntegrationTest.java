package com.example.coin.integration;

import com.example.coin.presentation.dto.MemberRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void 회원가입_조회_곡추가까지_전체흐름_성공() throws Exception {

        // 1) 회원가입 요청
        MemberRequestDto dto = new MemberRequestDto("홍길동", "010-1234-5678");

        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("홍길동"))
                .andExpect(jsonPath("$.phoneNumber").value("010-1234-5678"));

        // 2) 회원 조회
        mockMvc.perform(get("/members/010-1234-5678"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("홍길동"));

        // 3) 곡 수 추가
        mockMvc.perform(patch("/members/010-1234-5678/songs?count=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.songCount").value(3));
    }
}
