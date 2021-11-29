package com.triplan.service.inf;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.ReservationDTO;

import java.time.LocalDateTime;
import java.util.List;


public interface ReservationService {

    void insert(ReservationDTO reservationDTO);

    ReservationDTO select(Integer resId, Integer memberId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId, Integer memberId);

    List<ReservationDTO> myResList(Integer memberId);

    List<ReservationDTO> myUpcomingResList(Integer memberId);

    List<ReservationDTO> myPastResList(Integer memberId);

    List<ReservationDTO> myCancelledResList(Integer memberId);

    Integer reserve(Integer memberCouponId, ReservationDTO reservationDTO, Integer itemId, LocalDateTime startDate, LocalDateTime endDate);

    Integer cancel(Integer resId, ReservationDTO reservationDTO, Integer memberId);

    Pagination<ReservationDTO> myPagedResList(Integer memberId, Integer pageSize, Integer currentPage);

}
