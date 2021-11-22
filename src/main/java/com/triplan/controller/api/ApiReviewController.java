package com.triplan.controller.api;

import com.triplan.domain.item.ReviewVO;
import com.triplan.dto.response.customer.ReviewDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor

public class ApiReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String reviewInsert(
            @RequestPart("review") @Valid ReviewVO reviewVO,
            @RequestPart(value = "file", required = false) List<MultipartFile> files,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember.getMemberId();
        reviewVO.setMemberId(memberId);
        reviewService.reviewInsert(reviewVO, files);
        return "정보 입력 성공";
    }

    @GetMapping("/{reviewId}")
    public ReviewVO reviewRead(@PathVariable Integer reviewId) {
        ReviewVO result = reviewService.reviewRead(reviewId);
        return result;
    }

    @PutMapping("/{reviewId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String reviewUpdate(
            @PathVariable Integer reviewId,
            @RequestPart("review") ReviewVO reviewVO,
            @RequestPart("file") List<MultipartFile> files,
            @CurrentMember MemberPrincipal currentMember
    ) {
        reviewVO.setMemberId(currentMember.getMemberId());
        reviewVO.setReviewId(reviewId);
        reviewService.reviewUpdate(reviewVO, files);
        return "정보 수정 완료";
    }

   @DeleteMapping("/{reviewId}")
   @PreAuthorize("hasRole('ROLE_MEMBER')")
    public String reviewDelete(
            @PathVariable Integer reviewId,
            @CurrentMember MemberPrincipal currentMember
   ){
        Integer memberId = currentMember.getMemberId();
        reviewService.reviewDelete(reviewId, memberId);
        return "정보 삭제 완료";
    }

    @GetMapping
    public List<ReviewVO> reviewList(){
        return reviewService.reviewList();
    }

    /* 페이징 처리 */
    @GetMapping("/item-groups/{itemGroupId}")
    public Pagination<ReviewDTO> reviewPage(
            @PathVariable Integer itemGroupId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage
    ) {
        return reviewService.listByItemGroupId(itemGroupId, pageSize, currentPage);
    }

}
