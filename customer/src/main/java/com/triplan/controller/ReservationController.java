package com.triplan.controller;

import com.triplan.domain.MemberVO;
import com.triplan.dto.ReservationDTO;
import com.triplan.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/res")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public String register(@RequestBody ReservationDTO reservationDTO) {
        reservationService.register(reservationDTO);
        return "예약 추가 성공";
    }

    @GetMapping("/{resId}")
    public ReservationDTO getReservation(@PathVariable Integer resId) {
        return reservationService.getReservation(resId);
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