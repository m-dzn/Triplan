package com.triplan.service;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.WishlistResponseDTO;
import com.triplan.mapper.WishlistMapper;
import com.triplan.service.inf.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistMapper wishlistMapper;

    @Override
    public void addToWishlist(Integer memberId, Integer itemId) {
        wishlistMapper.insert(memberId, itemId);
    }

    @Override
    public void removeFromWishlist(Integer wishlistId) {
        wishlistMapper.delete(wishlistId);
    }

    @Override
    public Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage) {
        List<WishlistResponseDTO> wishlistList = wishlistMapper.list(memberId);

        return new Pagination<>(pageSize, currentPage, 1, wishlistList);
    }


}
