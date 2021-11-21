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

    //Seller Main 페이지
    Integer selectCount(Integer sellerId);

    List<ReservationVO> myResList(Integer memberId);

    List<ReservationVO> myUpcomingResList(Integer memberId);

    List<ReservationVO> myPastResList(Integer memberId);

    List<ReservationVO> myCancelledResList(Integer memberId);

    void insertResItem(@Param("resId") Integer resId, @Param("itemScheduleId") Integer itemScheduleId);

    Integer checkCoupon(Integer memberCouponId);

    Integer checkMemberCoupon(@Param("memberCouponId") Integer memberCouponId, @Param("memberId") Integer memberId);

    void useCoupon(@Param("resId") Integer resId, @Param("memberCouponId") Integer memberCouponId,
                   @Param("memberId") Integer memberId);

    void cancel(ReservationDTO reservationDTO);

    Integer getMemberId(Integer resId);

    Integer checkExpiredCoupon(Integer resId);

    void giveBackCoupon(@Param("resId") Integer resId, @Param("memberId") Integer memberId);

    List<ReservationDTO> myPagedResList(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    Integer count(Integer memberId);
  
    void updateStockByItemSchedule(Integer itemScheduleId);

    void updateSalesVolumeByItem(Integer itemScheduleId);
  
}