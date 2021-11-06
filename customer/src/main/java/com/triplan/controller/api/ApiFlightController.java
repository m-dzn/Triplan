package com.triplan.controller.api;

import com.triplan.domain.FlightVO;
import com.triplan.service.inf.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class ApiFlightController {

    private final FlightService flightService;

    @PostMapping
    public String flightInsert(@RequestBody FlightVO flightVO) {
        flightService.flightInsert(flightVO);
        return "flight insert succeed";
    }

    @GetMapping("/{flightId}")
    public FlightVO flightSelect(@PathVariable Integer flightId) {
        return flightService.flightSelect(flightId);
    }

    @PutMapping("/{flightId}")
    public String flightUpdate(@PathVariable Integer flightId, @RequestBody FlightVO flightVO) {
        flightVO.setFlightId(flightId);
        flightService.flightUpdate(flightVO);
        return "flight update succeed";
    }

    @DeleteMapping("/{flightId}")
    public String flightDelete(@PathVariable Integer flightId) {
        flightService.flightDelete(flightId);
        return "flight delete succeed";
    }

}
