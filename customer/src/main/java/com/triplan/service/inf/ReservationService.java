package com.triplan.service.inf;

import com.triplan.dto.ReservationDTO;


public interface ReservationService {

    void insert(ReservationDTO reservationDTO);

    ReservationDTO select(Integer resId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId);


}
