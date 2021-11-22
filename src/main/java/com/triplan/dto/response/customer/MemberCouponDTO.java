package com.triplan.dto.response.customer;

import com.triplan.domain.member.MemberCouponVO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberCouponDTO {

    private Integer memberCouponId;

    private Boolean usage1;

    private LocalDateTime usedAt;

    @NotNull(message = "memberId는 필수 값입니다.")
    private Integer memberId;
    @NotNull(message = "couponId는 필수 값입니다.")
    private Integer couponId;
    private Integer resId;


    // CouponDTO field
    private String name;
    private Long price;
    private String condition;
    private LocalDateTime expiredAt;


    public static MemberCouponDTO of(MemberCouponVO memberCouponVO){
        return MemberCouponDTO.builder()
                .memberCouponId(memberCouponVO.getMemberCouponId())
                .usage1(memberCouponVO.getUsage1())
                .usedAt(memberCouponVO.getUsedAt())
                .memberId(memberCouponVO.getMemberId())
                .couponId(memberCouponVO.getCouponId())
                .resId(memberCouponVO.getMemberCouponId())
                .build();
    }

    public MemberCouponVO toVO() {
        return MemberCouponVO.builder()
                .memberCouponId(memberCouponId)
                .usage1(usage1)
                .usedAt(usedAt)
                .memberId(memberId)
                .couponId(couponId)
                .resId(resId)
                .build();
    }

/*
    public static MemberCouponDTO of2(MemberCouponVO memberCouponVO, CouponDTO couponDTO){
        return MemberCouponDTO.builder()
                .memberCouponId(memberCouponVO.getMemberCouponId())
                .usage1(memberCouponVO.getUsage1())
                .usedAt(memberCouponVO.getUsedAt())
                .memberId(memberCouponVO.getMemberId())
                .couponId(memberCouponVO.getCouponId())
                .resId(memberCouponVO.getMemberCouponId())
                .name(couponDTO.getName())
                .price(couponDTO.getPrice())
                .condition(couponDTO.getCondition())
                .expiredAt(couponDTO.getExpiredAt())
                .build();
    }

 */



}
