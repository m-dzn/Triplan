package com.triplan.controller.api;

import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.WishlistResponseDTO;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlists")
@RequiredArgsConstructor
public class ApiWishlistController {

    private final WishlistService wishListService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String addToWishList(
            @RequestParam Integer itemGroupId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        wishListService.addToWishlist(memberId, itemGroupId);
        return "위시리스트 추가 성공";
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String removeByItemGroupId(
            @RequestParam Integer itemGroupId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        wishListService.removeByItemGroupId(itemGroupId, memberId);
        return "위시리스트 제거 성공";
    }

    @DeleteMapping("/{wishListId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String removeFromWishList(
            @PathVariable Integer wishListId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        wishListService.removeFromWishlist(wishListId, memberId);
        return "위시리스트 제거 성공";
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public Pagination<WishlistResponseDTO> getMemberWishList(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        return wishListService.getMemberWishList(memberId, pageSize, currentPage);
    }

}