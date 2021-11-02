package com.triplan.domain;

import com.triplan.enumclass.PaymentState;
import com.triplan.enumclass.PaymentType;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class PaymentVO {

    private int paymentId;

    private int resId;

    private PaymentState state;

    private PaymentType type;

    private int price;

    private Timestamp paymentDeadline;

    private LocalDateTime createdAt;

    private Timestamp updatedAt;

    public static void main(String[] arg){

      PaymentVO vo = new PaymentVO();
      vo.setState(PaymentState.PaymentFailed);

      System.out.println(vo.getState());
      System.out.println(vo.getState().getExplain());
    }


}
