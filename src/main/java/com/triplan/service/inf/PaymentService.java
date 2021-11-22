package com.triplan.service.inf;

import com.triplan.domain.item.PaymentVO;

public interface PaymentService {

    void create(PaymentVO paymentVO, Integer memberId);

    PaymentVO read(Integer paymentId, Integer memberId);

    void update(Integer paymentId, PaymentVO paymentVO, Integer memberId);

    void delete(Integer paymentId, Integer memberId);

    String readNameByItem(Integer resId);
}
