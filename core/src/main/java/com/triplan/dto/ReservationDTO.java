package com.triplan.dto;

import com.triplan.domain.ReservationVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer resId;
    @NotNull(message = "itemCategory는 필수 값입니다.")
    private ItemCategory itemCategory;
    @NotNull(message = "totalPrice는 필수 값입니다.")
    @PositiveOrZero
    private Long totalPrice;
    @NotNull(message = "startDate는 필수 값입니다.")
    @Future
    private LocalDateTime startDate;
    @NotNull(message = "endDate는 필수 값입니다.")
    @Future
    private LocalDateTime endDate;
    @NotEmpty(message = "name는 필수 값입니다.")
    @Size(min = 2, max = 10, message = "name은 2자 이상 10자 이내로 입력해주십시오.")
    private String name;
    @NotEmpty(message = "phone는 필수 값입니다.")
    @Pattern(regexp="^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$", message = "010-xxx-xxxx 형식으로 입력해주십시오.")
    private String phone;
    private Long totalDiscountPrice;

    private Boolean cancellation;

    @NotNull(message = "memberId는 필수 값입니다.")
    private Integer memberId;
    @NotNull(message = "sellerId는 필수 값입니다.")
    private Integer sellerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;


    public static ReservationDTO of(ReservationVO reservationVO){
        return ReservationDTO.builder()
                .resId(reservationVO.getResId())
                .itemCategory(reservationVO.getItemCategory())
                .totalPrice(reservationVO.getTotalPrice())
                .startDate(reservationVO.getStartDate())
                .endDate(reservationVO.getEndDate())
                .name(reservationVO.getName())
                .phone(reservationVO.getPhone())
                .totalDiscountPrice(reservationVO.getTotalDiscountPrice())
                .memberId(reservationVO.getMemberId())
                .sellerId(reservationVO.getSellerId())
                .cancellation(reservationVO.getCancellation())
                .createdAt(reservationVO.getCreatedAt())
                .updatedAt(reservationVO.getUpdatedAt())
                .build();
    }

    public ReservationVO toVO() {
        return ReservationVO.builder()
                .resId(resId)
                .itemCategory(itemCategory)
                .totalPrice(totalPrice)
                .startDate(startDate)
                .endDate(endDate)
                .name(name)
                .phone(phone)
                .totalDiscountPrice(totalDiscountPrice)
                .memberId(memberId)
                .sellerId(sellerId)
                .cancellation(cancellation)
                .build();
    }

}
