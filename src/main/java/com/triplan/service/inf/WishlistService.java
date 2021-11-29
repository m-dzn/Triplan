package com.triplan.service.inf;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.WishlistResponseDTO;

public interface WishlistService {

    void addToWishlist(Integer memberId, Integer itemGroupId);

    void removeByItemGroupId(Integer itemGroupId, Integer memberId);

    void removeFromWishlist(Integer wishlistId, Integer memberId);

    Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage);

}
