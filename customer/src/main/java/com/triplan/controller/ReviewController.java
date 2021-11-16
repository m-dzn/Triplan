
package com.triplan.controller;





import com.triplan.domain.ReviewVO;
import com.triplan.dto.ReviewDTO;
import com.triplan.enumclass.AboutTableType;
import com.triplan.service.inf.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping({"/review"})
    public String review(){
        return "product_detail";
    }


    @GetMapping("/reviewFileUpdate")
    public String reviewFile() {

        return  "Testfile";

    }
    /* 파일 업로드 */
    @PostMapping("/review/save")
    public String listFile( ReviewVO reviewVO,
                           @RequestParam("file")List<MultipartFile> files,
                           AboutTableType aboutTableType) throws IOException {
       reviewService.reviewInsert(reviewVO,files,aboutTableType);

        return "redirect:/review/reviewList";
    }

    @GetMapping("/review/reviewList")
    public String reviewList(Model model){

        List<ReviewVO> reviewVOList = reviewService.reviewList();
        model.addAttribute("reviewList",reviewVOList);
        return "Test";
    }

    /* 파일 수정 */


}


