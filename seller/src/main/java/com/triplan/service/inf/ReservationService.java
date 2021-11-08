package com.triplan.service.inf;

import com.triplan.dto.ReservationDTO;


public interface ReservationService {

    void register(ReservationDTO reservationDTO);

    ReservationDTO getReservation(Integer resId);

    void update(Integer reservationId, ReservationDTO reservationDTO);

    void delete(Integer resId);

    Integer reserve(ReservationDTO reservationDTO);

    Integer getCountReservation(Integer sellerId);
}
