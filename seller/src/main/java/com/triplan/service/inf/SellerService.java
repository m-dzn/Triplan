package com.triplan.service.inf;

import com.triplan.domain.SellerVO;
import com.triplan.dto.SellerDTO;

public interface SellerService {

    void register(SellerVO sellerVO);

    SellerVO getSeller(Integer sellerId);

    void update(Integer sellerId, SellerVO sellerVO);

    void delete(Integer sellerId);

}
