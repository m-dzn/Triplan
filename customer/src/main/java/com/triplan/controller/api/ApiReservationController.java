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

    // 예약하기 -> 프론트에서 쿠폰 적용 안 할 시 memberCouponId == 0 으로 넘기기
    @PostMapping("/reserve/{itemScheduleId}/{memberCouponId}")
    public Integer reserve(@PathVariable Integer itemScheduleId, @PathVariable Integer memberCouponId,
                          @RequestBody ReservationDTO reservationDTO) {
        Integer result = reservationService.reserve(itemScheduleId, memberCouponId, reservationDTO);
        // * 받아와야할 거
        // - 상품 : itemCategory, totalPrice, startDate, endDate + itemScheduleId
        // - 사용자 입력 : name, phone
        // - 쿠폰 : totalDiscountPrice, couponId
        // - 회원 로그인 정보 : memberId

        // result : -1(예약 실패), 0(예약 실패-쿠폰 사용 불가), 1(예약 성공)
        return result;
    }

    // 예약 취소 : cancellation 0 -> 1
    @PutMapping("/cancel/{resId}")
    public Integer cancel(@PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        Integer result =  reservationService.cancel(resId, reservationDTO);
        // result : -1(예약 취소 실패), 0(예약 취소이나 쿠폰 반환 X), 1(예약 취소)
        return result;
    }

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