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

    @PutMapping("/update/{resId}")
    public String update(@PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        reservationService.update(resId, reservationDTO);
        return "예약 수정 성공";
    }

    @DeleteMapping("/delete/{resId}")
    public String delete(@PathVariable Integer resId) {
        reservationService.delete(resId);
        // RESERVATION_ITEM TABLE ON DELETE CASCADE
        return "예약 삭제 성공";
    }

    // 예약하기
    @PostMapping("/reserve/{itemScheduleId}")
    public String reserve(@PathVariable Integer itemScheduleId, @RequestBody ReservationDTO reservationDTO) {
        reservationService.reserve(itemScheduleId, reservationDTO);
        // + 쿠폰 사용처리 하기(`usage1` + `item_id`)
        // 따로 가져와야할거 ) itemCategory, totalPrice, startDate, endDate, sellerId + memberId

        // URL로 itemScheduleId 넘기기
        // 받아와야할 거
        // - 상품 : itemCategory, totalPrice, startDate, endDate + itemScheduleId
        // - 사용자 입력 : name, phone
        // - 쿠폰 : totalDiscountPrice
        // - 회원 로그인 정보 : memberId
        return "상품 예약 성공";
    }

    // 예약 취소 : cancellation 0 -> 1
    @PutMapping("/cancel/{resId}")
    public String cancel(@PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        reservationService.cancel(resId, reservationDTO);
        return "상품 예약 취소 성공";
    }

    // + 페이징 처리 여부
    // 나외 예약 조회 (최신 여행 일자 순으로)
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

    // 나의 예약 조회 - 취소된 여행 (여행 취소 일자 순)
    @GetMapping("/myCancelledResList/{memberId}")
    public List<ReservationDTO> myCancelledResList(@PathVariable Integer memberId) {
        return reservationService.myCancelledResList(memberId);
    }
}