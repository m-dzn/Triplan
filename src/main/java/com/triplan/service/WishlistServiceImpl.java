package com.triplan.service;

import com.triplan.domain.item.ItemGroupVO;
import com.triplan.domain.member.WishlistVO;
import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.WishlistResponseDTO;
import com.triplan.exception.AccessNotAllowedException;
import com.triplan.mapper.item.ItemGroupMapper;
import com.triplan.mapper.member.WishlistMapper;
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
    public void removeByItemGroupId(Integer itemGroupId, Integer memberId) {
        WishlistVO wishlistVO = wishlistMapper.selectByItemGroupIdAndMemberId(itemGroupId, memberId);

        if (isMemberWhoAdded(wishlistVO.getMemberId(), memberId)) {
            ItemGroupVO itemGroupVO = itemGroupMapper.select(itemGroupId);
            itemGroupVO.decreaseLikeCount();
            itemGroupMapper.update(itemGroupVO);

            wishlistMapper.deleteByItemGroupId(itemGroupId);
        }
    }

    @Override
    @Transactional
    public void removeFromWishlist(Integer wishlistId, Integer memberId) {
        WishlistVO wishlistVO = wishlistMapper.select(wishlistId);

        if (isMemberWhoAdded(wishlistVO.getMemberId(), memberId)) {
            ItemGroupVO itemGroupVO = itemGroupMapper.select(wishlistVO.getItemGroupId());
            itemGroupVO.decreaseLikeCount();
            itemGroupMapper.update(itemGroupVO);

            wishlistMapper.delete(wishlistId);
        }
    }

    @Override
    public Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage) {
        List<WishlistResponseDTO> wishlistList = wishlistMapper.list(memberId, pageSize, currentPage);
        Integer count = wishlistMapper.countByMemberId(memberId);

        return new Pagination<>(pageSize, currentPage, count, wishlistList);
    }

    private boolean isMemberWhoAdded(Integer wishMemberId, Integer reqMemberId) {
        try {
            if (reqMemberId.equals(wishMemberId)) {
                return true;
            } else {
                throw new AccessNotAllowedException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
