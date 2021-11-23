package com.triplan.controller.api;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.ReservationDTO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/api/res")
@RequiredArgsConstructor
public class ApiReservationController {

    private final ReservationService reservationService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String insert(
            @Valid @RequestBody ReservationDTO reservationDTO,
            @CurrentMember MemberPrincipal currentMember
    ) {
        reservationDTO.setMemberId(currentMember.getMemberId());
        reservationService.insert(reservationDTO);
        return "resCreated";
    }

    @GetMapping("/{resId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public ReservationDTO select(
            @PathVariable Integer resId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.select(resId, memberId);
    }

    @PutMapping("/update/{resId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String update(
            @Valid @PathVariable Integer resId,
            @RequestBody ReservationDTO reservationDTO,
            @CurrentMember MemberPrincipal currentMember
    ) {
        reservationDTO.setMemberId(currentMember.getMemberId());
        reservationService.update(resId, reservationDTO);
        return "resUpdated";
    }

    @DeleteMapping("/delete/{resId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String delete(
            @PathVariable Integer resId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        reservationService.delete(resId, memberId);
        // RESERVATION_ITEM TABLE ON DELETE CASCADE
        return "resDeleted";
    }

    // 예약하기 -> 프론트에서 쿠폰 적용 안 할 시 memberCouponId == 0 으로 넘기기
    @PostMapping("/reserve/{memberCouponId}")
    public Integer reserve(
            @PathVariable Integer memberCouponId,
            @RequestParam Integer itemId,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @Valid @RequestBody ReservationDTO reservationDTO,
            @CurrentMember MemberPrincipal currentMember
    ) {
        reservationDTO.setMemberId(currentMember.getMemberId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startDateLDT = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime endDateLDT = LocalDate.parse(endDate, formatter).atTime(23,59,59);

        Integer resId = reservationService.reserve(memberCouponId, reservationDTO, itemId, startDateLDT, endDateLDT);
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
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Integer cancel(
            @PathVariable Integer resId,
            @RequestBody ReservationDTO reservationDTO,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        Integer result =  reservationService.cancel(resId, reservationDTO, memberId);
        // result : -1(예약 취소 실패), 0(예약 취소이나 쿠폰 반환 X), 1(예약 취소)
        return result;
    }

    // 나외 예약 조회 (최신 여행 일자 순으로)
    @GetMapping("/myResList")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<ReservationDTO> myResList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.myResList(memberId);
    }

    // 나의 예약 조회 - 예정된 여행
    @GetMapping("/myUpcomingResList")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<ReservationDTO> myUpcomingResList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.myUpcomingResList(memberId);
    }

    // 나의 예약 조회 - 지난 여행
    @GetMapping("/myPastResList")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<ReservationDTO> myPastResList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.myPastResList(memberId);
    }

    // 나의 예약 조회 - 취소된 여행 (여행 취소 일자 순)
    @GetMapping("/myCancelledResList")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public List<ReservationDTO> myCancelledResList(@CurrentMember MemberPrincipal currentMember) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.myCancelledResList(memberId);
    }

    // 나의 예약 전체 리스트 - 페이징 처리
    @GetMapping("/myPagedResList")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Pagination<ReservationDTO> myPagedResList(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        return reservationService.myPagedResList(memberId, pageSize, currentPage);
    }

}