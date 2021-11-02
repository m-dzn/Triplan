package com.triplan.service;

import com.triplan.domain.ReservationVO;
import com.triplan.domain.SellerVO;
import com.triplan.dto.ReservationDTO;
import com.triplan.dto.SellerDTO;
import com.triplan.mapper.ReservationMapper;
import com.triplan.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Transactional
    public void register(ReservationDTO reservationDTO) {
        ReservationVO reservationVO = reservationDTO.toVO();
        reservationMapper.insert(reservationVO);
    }

    @Override
    public ReservationDTO getReservation(Long resId) {
        ReservationVO reservationVO = reservationMapper.read(resId);
        return ReservationDTO.of(reservationVO);
    }

    @Override
    public void update(Long resId, ReservationDTO reservationDTO) {
        reservationDTO.setResId(resId);
        reservationMapper.update(reservationDTO);
    }

    @Override
    public void delete(Long resId) {
        reservationMapper.delete(resId);
    }

}
