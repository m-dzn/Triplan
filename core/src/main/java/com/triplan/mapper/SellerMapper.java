package com.triplan.mapper;

import com.triplan.domain.SellerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {

    void insert(SellerVO sellerVO);

    SellerVO read(int sellerId);

    void update(SellerVO sellerVO);

    void delete(int sellerId);
}
