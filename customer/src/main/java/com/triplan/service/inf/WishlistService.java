package com.triplan.service.inf;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.WishlistResponseDTO;

public interface WishlistService {

    void addToWishlist(Integer memberId, Integer itemGroupId);

    void removeFromWishlist(Integer wishlistId);

    Pagination<WishlistResponseDTO> getMemberWishList(Integer memberId, Integer pageSize, Integer currentPage);

}
