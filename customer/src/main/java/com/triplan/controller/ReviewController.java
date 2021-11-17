
package com.triplan.controller;





import com.triplan.domain.AttachmentVO;
import com.triplan.domain.ReviewVO;
import com.triplan.dto.ReviewDTO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.ReviewService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping({"/review/Page"})
    public String review(){
        return "product_detail";
    }


    @GetMapping("/reviewFileUpdate")
    public String reviewFile() {

        return  "Testfile";

    }
    /* 파일 업로드 */
    @PostMapping("/fileUpload")
    public String reviewInsert(ReviewVO reviewVO,
                           @RequestParam("file")List<MultipartFile> files,
                           AboutTableType aboutTableType) {
       reviewService.reviewInsert(reviewVO,files,aboutTableType);

        return "redirect:/review/fileList";
    }

    @GetMapping("/fileList")
    public String reviewList(Model model){

        List<ReviewVO> reviewVOList = reviewService.reviewList();
        model.addAttribute("reviewList",reviewVOList);
        return "Test";
    }



    @PostMapping("/fileUpdate")
    public String reviewUpdate
            (ReviewVO reviewVO,
             @RequestParam("file") List<MultipartFile> files, Model model){
        // TODO : 2) ServiceImpl에서 삭제할 Attachment id를 AttachmentUtil에 넣고 delete
        // TODO : 3) ServiceImpl에서 삭제할 Attachment id를 AttachmentMapper에 넣고 delete

        ReviewVO response = reviewService.reviewUpdate(reviewVO, files);
        model.addAttribute("review",response);
        return "Test";
    }

    @PostMapping("/delete")
    public String reviewDelete(@RequestParam Integer reviewId,@RequestParam("aboutTableType") AboutTableType aboutTableType){
        reviewService.reviewDelete(aboutTableType.name(),reviewId);

        return "Test";
    }



}


