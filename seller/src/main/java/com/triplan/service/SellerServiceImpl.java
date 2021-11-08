package com.triplan.service;

import com.triplan.domain.SellerVO;
import com.triplan.dto.SellerDTO;
import com.triplan.mapper.SellerMapper;
import com.triplan.service.inf.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;

    @Override
    public void register(SellerVO sellerVO) {
        sellerMapper.insert(sellerVO);
    }

    @Override
    public SellerVO getSeller(Integer sellerId) {
        return sellerMapper.read(sellerId);
    }

    @Override
    public void update(Integer sellerId, SellerVO sellerVO) {
        sellerVO.setSellerId(sellerId);
        sellerMapper.update(sellerVO);
    }

    @Override
    public void delete(Integer sellerId) {
        sellerMapper.delete(sellerId);
    }

}
