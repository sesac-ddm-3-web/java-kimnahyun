package com.example.coin.presentation;

import com.example.coin.application.RoomService;
import com.example.coin.domain.Room;
import com.example.coin.domain.RoomStatus;
import com.example.coin.global.BusinessException;
import com.example.coin.global.ErrorCode;
import com.example.coin.presentation.dto.RoomResponseDto;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomController.class)
@Import(com.example.coin.global.GlobalExceptionHandler.class)
class RoomControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    RoomService roomService;

    @Test
    void 방상태변경_성공() throws Exception {
        Room room = new Room(1);
        room.changeStatus(RoomStatus.USING);
        RoomResponseDto response = new RoomResponseDto(room);

        when(roomService.changeRoomStatus(1, "USING"))
                .thenReturn(room);

        mvc.perform(patch("/rooms/1/status?status=USING"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomNumber").value(1))
                .andExpect(jsonPath("$.status").value("USING"));
    }

    @Test
    void 방상태변경_잘못된값_예외() throws Exception {

        when(roomService.changeRoomStatus(anyInt(), anyString()))
                .thenThrow(new BusinessException(ErrorCode.INVALID_ROOM_STATUS));

        mvc.perform(patch("/rooms/1/status?status=WRONG"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("입력된 방 상태가 올바르지 않습니다."));
    }

    @Test
    void 방전체조회_성공() throws Exception {
        Room r1 = new Room(1);
        Room r2 = new Room(2);

        when(roomService.getAllRoom()).thenReturn(
                List.of(new RoomResponseDto(r1), new RoomResponseDto(r2))
        );

        mvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].roomNumber").value(1))
                .andExpect(jsonPath("$[1].roomNumber").value(2));
    }
}
