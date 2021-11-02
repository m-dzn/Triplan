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

    @GetMapping("/{roomId}")
    public RoomVO roomSelect(@PathVariable int roomId) {
        return roomService.roomSelect(roomId);
    }

    @PutMapping("/{roomId}")
    public String roomUpdate(@PathVariable int roomId, @RequestBody RoomVO roomVO) {
        roomVO.setRoomId(roomId);
        roomService.roomUpdate(roomVO);
        return "room update succeed";
    }

    @DeleteMapping("/{roomId}")
    public String roomDelete(@PathVariable int roomId) {
        roomService.roomDelete(roomId);
        return "room delete succeed";
    }

}
