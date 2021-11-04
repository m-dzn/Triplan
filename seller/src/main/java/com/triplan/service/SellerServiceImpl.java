package com.triplan.service;

import com.triplan.domain.SellerVO;
import com.triplan.dto.SellerDTO;
import com.triplan.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;

    @Transactional
    public void register(SellerDTO sellerDTO) {
        SellerVO sellerVO = sellerDTO.toVO();
        sellerMapper.insert(sellerVO);
    }

    @Override
    public SellerDTO getSeller(Integer sellerId) {
        SellerVO sellerVO = sellerMapper.read(sellerId);
        return SellerDTO.of(sellerVO);
    }

    @Override
    public void update(Integer sellerId, SellerDTO sellerDTO) {
        sellerDTO.setSellerId(sellerId);
        sellerMapper.update(sellerDTO);
    }

    @Override
    public void delete(Integer sellerId) {
        sellerMapper.delete(sellerId);
    }

}
