package com.triplan.mapper;

import com.triplan.domain.SellerVO;
import com.triplan.dto.SellerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {

    void insert(SellerVO sellerVO);

    SellerVO read(Integer seller_id);

    void update(SellerDTO sellerDTO);

    void delete(Integer seller_id);

}