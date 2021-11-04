package com.triplan.domain;

import com.triplan.enumclass.PersonalOrCompany;
import com.triplan.enumclass.ProductGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SellerVO {
    private Integer sellerId;
    private Integer memberId;
    private ProductGroup productGroup;
    private String businessLicenseNumber;
    private String businessName;
    private String tel;
    private String ownerName;
    private String address;
    private String zipCode;
    private String email;
    private String sellerImg;
    private String businessAccount;
    private PersonalOrCompany personalOrCompany;
}
