package com.triplan.service.inf;

import com.triplan.dto.ReservationDTO;
import com.triplan.dto.response.Pagination;

import java.util.List;


public interface ReservationService {

    void insert(ReservationDTO reservationDTO);

    ReservationDTO select(Integer resId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId);

    List<ReservationDTO> myResList(Integer memberId);

    List<ReservationDTO> myUpcomingResList(Integer memberId);

    List<ReservationDTO> myPastResList(Integer memberId);

    List<ReservationDTO> myCancelledResList(Integer memberId);

    Integer reserve(Integer itemScheduleId, Integer memberCouponId, ReservationDTO reservationDTO);

    Integer cancel(Integer resId, ReservationDTO reservationDTO);

    Pagination<ReservationDTO> myPagedResList(Integer memberId, Integer pageSize, Integer currentPage);
}
