package com.triplan.domain;

import com.triplan.enumclass.PaymentState;
import com.triplan.enumclass.PaymentType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaymentVO {

    private Integer paymentId;

    private Integer resId;

    private PaymentState state;

    private PaymentType type;

    private Integer price;

    private Timestamp paymentDeadline;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
