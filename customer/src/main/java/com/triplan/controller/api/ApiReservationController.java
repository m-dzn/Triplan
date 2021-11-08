package com.triplan.controller.api;

import com.triplan.dto.ReservationDTO;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    // 예약하기
    @PostMapping("/reserve")
    public String reserve(@RequestBody ReservationDTO reservationDTO) {
        reservationService.insert(reservationDTO);

        // 받아와야할 거
        // - 상품 : itemCategory, totalPrice, startDate, endDate
        // - 사용자 입력 : name, phone
        // - 쿠폰 : totalDiscountPrice
        // - 회원 로그인 정보 : memberId

        return "상품 예약 성공";
    }

    // 나외 예약 조회 (최근 예약일 순으로)
    @GetMapping("/myResList/{memberId}")
    public List<ReservationDTO> myResList(@PathVariable Integer memberId) {
        return reservationService.myResList(memberId);
    }

    // 나의 예약 조회 - 예정된 여행
    @GetMapping("/myUpcomingResList/{memberId}")
    public List<ReservationDTO> myUpcomingResList(@PathVariable Integer memberId) {
        return reservationService.myUpcomingResList(memberId);
    }

    // 나의 예약 조회 - 지난 여행
    @GetMapping("/myPastResList/{memberId}")
    public List<ReservationDTO> myPastResList(@PathVariable Integer memberId) {
        return reservationService.myPastResList(memberId);
    }

}