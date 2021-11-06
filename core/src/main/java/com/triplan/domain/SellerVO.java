package com.triplan.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SellerVO {

    // 식별자 필드
    private Integer sellerId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String businessLicenseNumber;
    private String businessName;
    private String tel;
    private String ownerName;
    private String email;
    private String businessAccount;
    private Boolean privateBusiness;
    private String zipCode;
    private String address;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드
    private String addressDetail;
    private String sellerImg;

    // 외래키
    private Integer memberId;

}
