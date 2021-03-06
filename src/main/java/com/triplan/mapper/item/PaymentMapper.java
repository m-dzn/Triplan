package com.triplan.mapper.item;

import com.triplan.domain.item.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    void insert(PaymentVO paymentVO);

    PaymentVO select(Integer paymentId);

    void update(PaymentVO paymentVO);

    void delete(Integer paymentId);

    List<PaymentVO> getPaymentBySellerId(Integer sellerId);

    Long getYearPayment(Integer memberId);

    String getNameByItem(Integer resId);
}
