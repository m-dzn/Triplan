package com.triplan.controller;

import com.triplan.domain.RoomVO;
import com.triplan.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{room_id}")
    public RoomVO roomSelect(@PathVariable int room_id) {
        return roomService.roomSelect(room_id);
    }

    @PutMapping("/{room_id}")
    public String roomUpdate(@PathVariable int room_id, @RequestBody RoomVO roomVO) {
        roomVO.setRoom_id(room_id);
        roomService.roomUpdate(roomVO);
        return "room update succeed";
    }

    @DeleteMapping("/{room_id}")
    public String roomDelete(@PathVariable int room_id) {
        roomService.roomDelete(room_id);
        return "room delete succeed";
    }

}
