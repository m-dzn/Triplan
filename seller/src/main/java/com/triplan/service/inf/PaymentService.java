package com.triplan.service.inf;

import com.triplan.domain.PaymentVO;
import com.triplan.dto.seller.response.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    void create(PaymentVO paymentVO);

    PaymentVO read(Integer paymentId);

    void update(Integer paymentId, PaymentVO paymentVO);

    void delete(Integer paymentId);

    List<PaymentResponseDTO> readSellerId(Integer sellerId);
}
