package com.triplan.service;

import com.triplan.dto.SellerDTO;

public interface SellerService {

    void register(SellerDTO sellerDTO);

    SellerDTO getSeller(Integer sellerId);

    void update(Integer sellerId, SellerDTO sellerDTO);

    void delete(Integer sellerId);

}
