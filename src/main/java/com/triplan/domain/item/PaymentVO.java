package com.triplan.domain.item;

import com.triplan.domain.BaseVO;
import com.triplan.enumclass.item.PaymentState;
import com.triplan.enumclass.item.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaymentVO extends BaseVO {

    // 식별자 필드
    private Integer paymentId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private PaymentType type;
    private Integer totalPayment;
    private String accountBank;
    private String accountNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime paymentDeadline;
    private LocalDateTime paidAt;

    // Default 값이 있는 NOT NULL 필드
    private PaymentState state;

    // Nullable 필드

    // 외래키
    private Integer resId;

}
