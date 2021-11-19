package com.triplan.controller.api;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.WishlistResponseDTO;
import com.triplan.service.inf.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlists")
@RequiredArgsConstructor
public class ApiWishlistController {

    private final WishlistService wishListService;

    @PostMapping
    public String addToWishList(@RequestParam Integer itemGroupId) {
        Integer memberId = 1;
        wishListService.addToWishlist(memberId, itemGroupId);
        return "위시리스트 추가 성공";
    }

    @DeleteMapping("/{wishListId}")
    public String removeFromWishList(@PathVariable Integer wishListId) {
        wishListService.removeFromWishlist(wishListId);
        return "위시리스트 제거 성공";
    }

    @GetMapping
    public Pagination<WishlistResponseDTO> getMemberWishList(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
        Integer memberId = 1;
        return wishListService.getMemberWishList(memberId, pageSize, currentPage);
    }

}