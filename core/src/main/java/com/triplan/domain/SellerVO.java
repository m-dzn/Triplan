package com.triplan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SellerVO {
    private Long sellerId;
    private Long memberId;
    private String productGroup;
    private String businessLicenseNumber;
    private String businessName;
    private String tel;
    private String ownerName;
    private String address;
    private String zipCode;
    private String email;
    private String sellerImg;
    private String businessAccount;
    private String personalOrCompany;
}
