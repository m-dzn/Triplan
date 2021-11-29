package com.triplan.dto.response.seller;

import com.triplan.domain.item.PaymentVO;
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
