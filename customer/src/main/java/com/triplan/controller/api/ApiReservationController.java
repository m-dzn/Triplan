package com.triplan.controller.api;

import com.triplan.dto.ReservationDTO;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/res")
@RequiredArgsConstructor
public class ApiReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public String insert(@RequestBody ReservationDTO reservationDTO) {
        reservationService.insert(reservationDTO);
        return "예약 추가 성공";
    }

    @GetMapping("/{resId}")
    public ReservationDTO select(@PathVariable Integer resId) {
        return reservationService.select(resId);
    }

    @PutMapping("/{resId}")
    public String update(@PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        reservationService.update(resId, reservationDTO);
        return "예약 수정 성공";
    }

    @DeleteMapping("/{resId}")
    public String delete(@PathVariable Integer resId) {
        reservationService.delete(resId);
        return "예약 삭제 성공";
    }

}