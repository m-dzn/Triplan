package com.triplan.service;

import com.triplan.dto.ReservationDTO;


public interface ReservationService {

    void register(ReservationDTO reservationDTO);

    ReservationDTO getReservation(Long resId);

    void update(Long reservationId, ReservationDTO reservationDTO);

    void delete(Long resId);

}
