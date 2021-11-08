package com.triplan.service;

import com.triplan.domain.ReservationVO;
import com.triplan.dto.ReservationDTO;
import com.triplan.mapper.ReservationMapper;
import com.triplan.service.inf.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Transactional
    public void insert(ReservationDTO reservationDTO) {
        ReservationVO reservationVO = reservationDTO.toVO();
        reservationMapper.insert(reservationVO);
    }

    @Override
    public ReservationDTO select(Integer resId) {
        ReservationVO reservationVO = reservationMapper.select(resId);
        return ReservationDTO.of(reservationVO);
    }

    @Override
    public void update(Integer resId, ReservationDTO reservationDTO) {
        reservationDTO.setResId(resId);
        reservationMapper.update(reservationDTO);
    }

    @Override
    public void delete(Integer resId) {
        reservationMapper.delete(resId);
    }

    @Override
    public List<ReservationDTO> myResList(Integer memberId) {
        List<ReservationVO> reservationVOList = reservationMapper.myResList(memberId);
        List<ReservationDTO> reservationDTOList = reservationVOList.stream()
                .map(ReservationDTO::of).collect(Collectors.toList());
        // ReservationDTO :: of 란?
        // 람다식에서 Reservation -> ReservationDTO.of(memberId) 처럼 들어오는 매개변수랑 of 매개변수랑 같을 때 :: 을 사용해 처리
        // https://github.com/jamongjelly/Triplan/blob/edu_vo-dto/seller/src/main/java/com/triplan/service/ItemGroupServiceImpl.java
        return reservationDTOList;
    }

    @Override
    public List<ReservationDTO> myUpcomingResList(Integer memberId) {
        List<ReservationVO> reservationVOList = reservationMapper.myUpcomingResList(memberId);
        List<ReservationDTO> reservationDTOList = reservationVOList.stream()
                .map(ReservationDTO::of).collect(Collectors.toList());
        return reservationDTOList;
    }

    @Override
    public List<ReservationDTO> myPastResList(Integer memberId) {
        List<ReservationVO> reservationVOList = reservationMapper.myPastResList(memberId);
        List<ReservationDTO> reservationDTOList = reservationVOList.stream()
                .map(ReservationDTO::of).collect(Collectors.toList());
        return reservationDTOList;
    }


}
