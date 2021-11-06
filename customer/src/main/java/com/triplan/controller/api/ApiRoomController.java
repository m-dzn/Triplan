package com.triplan.controller.api;

import com.triplan.domain.RoomVO;
import com.triplan.service.inf.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class ApiRoomController {

    private final RoomService roomService;

    @PostMapping
    public String roomInsert(@RequestBody RoomVO roomVO) {
        roomService.roomInsert(roomVO);
        return "room insert succeed";
    }

    @GetMapping("/{roomId}")
    public RoomVO roomSelect(@PathVariable Integer roomId) {
        return roomService.roomSelect(roomId);
    }

    @PutMapping("/{roomId}")
    public String roomUpdate(@PathVariable Integer roomId, @RequestBody RoomVO roomVO) {
        roomVO.setRoomId(roomId);
        roomService.roomUpdate(roomVO);
        return "room update succeed";
    }

    @DeleteMapping("/{roomId}")
    public String roomDelete(@PathVariable Integer roomId) {
        roomService.roomDelete(roomId);
        return "room delete succeed";
    }

}
