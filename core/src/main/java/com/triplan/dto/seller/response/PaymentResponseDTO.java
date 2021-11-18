package com.triplan.dto.seller.response;

import com.triplan.domain.PaymentVO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {

    private LocalDateTime paidAt;
    private Integer totalPayment;

    public static PaymentResponseDTO of(PaymentVO vo) {
        return PaymentResponseDTO.builder()
                .paidAt(vo.getPaidAt())
                .totalPayment(vo.getTotalPayment())
                .build();
    }

}
