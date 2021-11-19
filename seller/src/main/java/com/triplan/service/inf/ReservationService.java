package com.triplan.service.inf;

import com.triplan.dto.ReservationDTO;


public interface ReservationService {

    ReservationDTO getReservation(Integer resId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId);

    Integer reserve(ReservationDTO reservationDTO);

    Integer getCountReservation(Integer sellerId);
}
