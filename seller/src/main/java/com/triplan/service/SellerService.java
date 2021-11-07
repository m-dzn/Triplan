package com.triplan.service;

import com.triplan.domain.SellerVO;
public interface SellerService {
        //dsad
    void register(SellerVO sellerVO);

    SellerVO getSeller(Integer sellerId);

    void update(Integer sellerId, SellerVO sellerVO);

    void delete(Integer sellerId);

}
