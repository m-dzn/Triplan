package com.triplan.controller;

import com.triplan.domain.QuestionVO;
import com.triplan.service.inf.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/write")
    public String register(QuestionVO questionVO) {
        questionService.create(questionVO);
        System.out.println(" C : Create 실행");
        return "qna";
    }

    @PutMapping("/{questionId}")
    public String update(@PathVariable Integer questionId, @RequestBody QuestionVO questionVO) {
        questionService.update(questionId, questionVO);
        return "수정 완료";
    }

}








