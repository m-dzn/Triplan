package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.WishlistResponseDTO;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.WishlistMapper;
import com.triplan.service.inf.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistMapper wishlistMapper;
    private final ItemGroupMapper itemGroupMapper;

    @Override
    @Transactional
    public void addToWishlist(Integer memberId, Integer itemId) {
        ItemGroupVO itemGroupVO = itemGroupMapper.selectByItemId(itemId);
        itemGroupVO.increaseLikeCount();
        itemGroupMapper.update(itemGroupVO);
        wishlistMapper.insert(memberId, itemId);
    }

    @Override
    @Transactional
    public void removeFromWishlist(Integer wishlistId) {
        ItemGroupVO itemGroupVO = wishlistMapper.selectItemGroupByWishlistId(wishlistId);
        itemGroupVO.decreaseLikeCount();
        itemGroupMapper.update(itemGroupVO);
        wishlistMapper.delete(wishlistId);
    }

    @Override
    public Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage) {
        List<WishlistResponseDTO> wishlistList = wishlistMapper.list(memberId);

        return new Pagination<>(pageSize, currentPage, 1, wishlistList);
    }


}
