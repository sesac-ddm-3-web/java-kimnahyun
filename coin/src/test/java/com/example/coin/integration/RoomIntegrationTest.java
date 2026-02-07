package com.example.coin.integration;

import com.example.coin.domain.RoomStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RoomIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 방상태변경_전체흐름_성공() throws Exception {

        // 1번 방은 초기 상태: FINISHED

        // USING으로 상태 변경
        mockMvc.perform(patch("/rooms/1/status?status=using"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(RoomStatus.USING.name()));

        // 전체 조회
        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].roomNumber").value(1))
                .andExpect(jsonPath("$[1].roomNumber").value(2))
                .andExpect(jsonPath("$[2].roomNumber").value(3))
                .andExpect(jsonPath("$[3].roomNumber").value(4));
    }
}
