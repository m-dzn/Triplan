package com.triplan.service;

import com.triplan.domain.SellerVO;
import com.triplan.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;

    @Override
    public void insertSeller(SellerVO sellerVO) {
        sellerMapper.insert(sellerVO);
    }

    @Override
    public SellerVO readSeller(int sellerId) {
        return sellerMapper.read(sellerId);
    }

    @Override
    public void update(int sellerId, SellerVO sellerVO) {
        sellerVO.setSellerId(sellerId);
        sellerMapper.update(sellerVO);
    }

    @Override
    public void delete(int sellerId) {
        sellerMapper.delete(sellerId);
    }
}
