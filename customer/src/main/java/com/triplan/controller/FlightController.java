package com.triplan.controller;

import com.triplan.domain.FlightVO;
import com.triplan.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public String flightInsert(@RequestBody FlightVO flightVO) {
        flightService.flightInsert(flightVO);
        return "flight insert succeed";
    }

    @GetMapping("/{flightId}")
    public FlightVO flightSelect(@PathVariable int flightId) {

        return flightService.flightSelect(flightId);
    }

    @PutMapping("/{flightId}")
    public String flightUpdate(@PathVariable int flightId, @RequestBody FlightVO flightVO) {
        flightVO.setFlightId(flightId);
        flightService.flightUpdate(flightVO);
        return "flight update succeed";
    }

    @DeleteMapping("/{flightId}")
    public String flightDelete(@PathVariable int flightId) {
        flightService.flightDelete(flightId);
        return "flight delete succeed";
    }

}
