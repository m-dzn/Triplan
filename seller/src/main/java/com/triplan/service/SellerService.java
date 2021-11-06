package com.triplan.service;

import com.triplan.dto.SellerDTO;

public interface SellerService {

    void register(SellerDTO sellerDTO);

    SellerDTO getSeller(Long sellerId);

    void update(Long sellerId, SellerDTO sellerDTO);

    void delete(Long sellerId);

}
