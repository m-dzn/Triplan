package com.triplan.service;

import com.triplan.domain.PaymentVO;

public interface PaymentService {


    void create(PaymentVO paymentVO);

    PaymentVO read(int paymentId);

    void update(int paymentId, PaymentVO paymentVO);

    void delete(int paymentId);

}
