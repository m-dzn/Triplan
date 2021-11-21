package com.triplan.controller.api;

import com.triplan.dto.ReservationDTO;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/res")
@RequiredArgsConstructor
public class ApiReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public String insert(@Valid @RequestBody ReservationDTO reservationDTO) {
        reservationService.insert(reservationDTO);
        return "resCreated";
    }

    @GetMapping("/{resId}")
    public ReservationDTO select(@PathVariable Integer resId) {
        return reservationService.select(resId);
    }

    @PutMapping("/update/{resId}")
    public String update(@Valid @PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        reservationService.update(resId, reservationDTO);
        return "resUpdated";
    }

    @DeleteMapping("/delete/{resId}")
    public String delete(@PathVariable Integer resId) {
        reservationService.delete(resId);
        // RESERVATION_ITEM TABLE ON DELETE CASCADE
        return "resDeleted";
    }

    // 예약하기 -> 프론트에서 쿠폰 적용 안 할 시 memberCouponId == 0 으로 넘기기
    @PostMapping("/reserve/{memberCouponId}")
    public Integer reserve(@RequestParam String itemScheduleId, @PathVariable Integer memberCouponId,
                          @Valid @RequestBody ReservationDTO reservationDTO) {
        List<Integer> itemScheduleIdList = new ArrayList<>();
        String splitArr[] = itemScheduleId.split(",");
        for(int i=0; i<splitArr.length; i++) {
            itemScheduleIdList.add(Integer.parseInt(splitArr[i]));
        }

        Integer resId = reservationService.reserve(itemScheduleIdList, memberCouponId, reservationDTO);
        // * 받아와야할 거
        // - 상품 : itemCategory, totalPrice, startDate, endDate + itemScheduleId
        // - 사용자 입력 : name, phone
        // - 쿠폰 : totalDiscountPrice, couponId
        // - 회원 로그인 정보 : memberId

        // result : -1(예약 실패), 0(예약 실패-쿠폰 사용 불가), 1(예약 성공)
        return resId;
    }

    // 예약 취소 : cancellation 0 -> 1
    @PutMapping("/cancel/{resId}")
    public Integer cancel(@PathVariable Integer resId, @RequestBody ReservationDTO reservationDTO) {
        Integer result =  reservationService.cancel(resId, reservationDTO);
        // result : -1(예약 취소 실패), 0(예약 취소이나 쿠폰 반환 X), 1(예약 취소)
        return result;
    }

    // 나외 예약 조회 (최신 여행 일자 순으로)
    @GetMapping("/myResList")
    public List<ReservationDTO> myResList() {
        Integer memberId = 1;
        return reservationService.myResList(memberId);
    }

    // 나의 예약 조회 - 예정된 여행
    @GetMapping("/myUpcomingResList")
    public List<ReservationDTO> myUpcomingResList() {
        Integer memberId = 1;
        return reservationService.myUpcomingResList(memberId);
    }

    // 나의 예약 조회 - 지난 여행
    @GetMapping("/myPastResList")
    public List<ReservationDTO> myPastResList() {
        Integer memberId = 1;
        return reservationService.myPastResList(memberId);
    }

    // 나의 예약 조회 - 취소된 여행 (여행 취소 일자 순)
    @GetMapping("/myCancelledResList/{memberId}")
    public List<ReservationDTO> myCancelledResList() {
        Integer memberId = 1;
        return reservationService.myCancelledResList(memberId);
    }
}