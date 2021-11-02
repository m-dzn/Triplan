package com.triplan.service;

import com.triplan.domain.SellerVO;

public interface SellerService {

    void insertSeller(SellerVO sellerVO);

    SellerVO readSeller(int sellerId);

    void update(int sellerId, SellerVO sellerVO);

    void delete(int sellerId);
}
