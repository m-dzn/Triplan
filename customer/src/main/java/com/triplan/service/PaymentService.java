package com.triplan.service;

import com.triplan.domain.PaymentVO;

public interface PaymentService {


    void create(PaymentVO paymentVO);

    PaymentVO read(Integer paymentId);

    void update(Integer paymentId, PaymentVO paymentVO);

    void delete(Integer paymentId);

}
