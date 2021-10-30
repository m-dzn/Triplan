package com.triplan.controller;

import com.triplan.domain.RoomVO;
import com.triplan.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/triplan/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public String roomInsert(@RequestBody RoomVO roomVO) {
        roomService.roomInsert(roomVO);
        return "room insert succeed";
    }

}
