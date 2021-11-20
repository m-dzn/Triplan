package com.triplan.service;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.WishlistVO;
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
    public void addToWishlist(Integer memberId, Integer itemGroupId) {
        ItemGroupVO itemGroupVO = itemGroupMapper.select(itemGroupId);
        itemGroupVO.increaseLikeCount();
        itemGroupMapper.update(itemGroupVO);
        wishlistMapper.insert(memberId, itemGroupId);
    }

    @Override
    @Transactional
    public void removeFromWishlist(Integer wishlistId) {
        WishlistVO wishlistVO = wishlistMapper.select(wishlistId);

        ItemGroupVO itemGroupVO = itemGroupMapper.select(wishlistVO.getItemGroupId());
        itemGroupVO.decreaseLikeCount();
        itemGroupMapper.update(itemGroupVO);

        wishlistMapper.delete(wishlistId);
    }

    @Override
    @Transactional
    public void removeByItemGroupId(Integer itemGroupId) {
        ItemGroupVO itemGroupVO = itemGroupMapper.select(itemGroupId);
        itemGroupVO.decreaseLikeCount();
        itemGroupMapper.update(itemGroupVO);

        wishlistMapper.deleteByItemGroupId(itemGroupId);
    }

    @Override
    public Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage) {
        List<WishlistResponseDTO> wishlistList = wishlistMapper.list(memberId, pageSize, currentPage);
        Integer count = wishlistMapper.countByMemberId(memberId);

        return new Pagination<>(pageSize, currentPage, count, wishlistList);
    }

}
