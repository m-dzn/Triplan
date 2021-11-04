package com.triplan.service;

import com.triplan.domain.PaymentVO;
import com.triplan.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;

    @Override
    public void create(PaymentVO paymentVO) {
        paymentMapper.insert(paymentVO);
    }

    @Override
    public PaymentVO read(Integer paymentId) {
        return paymentMapper.read(paymentId);
    }

    @Override
    public void update(Integer paymentId, PaymentVO paymentVO) {
        paymentVO.setPaymentId(paymentId);
        paymentMapper.update(paymentVO);
    }

    @Override
    public void delete(Integer paymentId) {
        paymentMapper.delete(paymentId);
    }


}
