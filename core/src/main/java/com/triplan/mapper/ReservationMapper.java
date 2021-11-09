package com.triplan.mapper;

import com.triplan.domain.ReservationVO;
import com.triplan.dto.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {

    Integer insert(ReservationVO reservationVO);

    ReservationVO select(Integer resId);

    void update(ReservationDTO reservationDTO);

    void delete(Integer resId);

    List<ReservationVO> myResList(Integer memberId);

    List<ReservationVO> myUpcomingResList(Integer memberId);

    List<ReservationVO> myPastResList(Integer memberId);

    List<ReservationVO> myCancelledResList(Integer memberId);

    void insertResItem(@Param("resId") Integer resId, @Param("itemScheduleId") Integer itemScheduleId);

    void cancel(ReservationDTO reservationDTO);
}