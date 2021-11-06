package com.triplan.mapper;

import com.triplan.domain.ReservationVO;
import com.triplan.dto.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {

    Integer insert(ReservationVO reservationVO);

    ReservationVO select(Integer resId);

    void update(ReservationDTO reservationDTO);

    void delete(Integer resId);

}