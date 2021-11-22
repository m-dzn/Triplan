package com.triplan.service;

import com.triplan.domain.item.PaymentVO;
import com.triplan.domain.item.ReservationVO;
import com.triplan.exception.AccessNotAllowedException;
import com.triplan.mapper.item.PaymentMapper;
import com.triplan.mapper.item.ReservationMapper;
import com.triplan.mapper.member.MemberMapper;
import com.triplan.service.inf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final MemberMapper memberMapper;
    private final ReservationMapper reservationMapper;

    @Override
    @Transactional
    public void create(PaymentVO paymentVO, Integer memberId) {
        paymentMapper.insert(paymentVO);
        Long yearPayment = paymentMapper.getYearPayment(memberId);
        memberMapper.updateGrade(memberId,yearPayment);
    }

    @Override
    public PaymentVO read(Integer paymentId, Integer memberId) {
        if (isMemberWhoPaid(paymentId, memberId)) {
            PaymentVO paymentVO = paymentMapper.select(paymentId);
            return paymentVO;
        } else {
            return null;
        }
    }

    @Override
    public void update(Integer paymentId, PaymentVO paymentVO, Integer memberId) {
        if (isMemberWhoPaid(paymentId, memberId)) {
            paymentVO.setPaymentId(paymentId);
            paymentMapper.update(paymentVO);
        }
    }

    @Override
    public void delete(Integer paymentId, Integer memberId) {
        if (isMemberWhoPaid(paymentId, memberId)) {
            paymentMapper.delete(paymentId);
        }
    }

    @Override
    public String readNameByItem(Integer itemId) {
        return paymentMapper.getNameByItem(itemId);
    }

    private boolean isMemberWhoPaid(Integer paymentId, Integer memberId) {
        // 예약 당사자와 예약 요청자가 일치하지 않으면 예외 처리
        try {
            ReservationVO reservationVO = reservationMapper.getReservationByPaymentId(paymentId);

            if (memberId.equals(reservationVO.getMemberId())) {
                return true;
            } else {
                throw new AccessNotAllowedException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
