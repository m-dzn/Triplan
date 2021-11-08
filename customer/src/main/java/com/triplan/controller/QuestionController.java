package com.triplan.controller;

import com.triplan.domain.QuestionVO;
import com.triplan.mapper.QuestionMapper;
import com.triplan.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController<questionVO> {

    private final QuestionService questionService;

    @PostMapping
    public String register(@RequestBody QuestionVO questionVO){
        questionService.create(questionVO);
        System.out.println(" C : Create 실행");
        return "board/list";
    }

    @GetMapping("/{questionId}")
    public QuestionVO getQuestion(@PathVariable int questionId){
        System.out.println(" C : getQ 실행@@@@@@@@@@@@");

        return questionService.getQuestion(questionId);
    }

    @PutMapping("/{questionId}")
    public String update(@PathVariable int questionId, @RequestBody QuestionVO questionVO){
        questionService.update(questionId, questionVO);
        return "수정 완료";
    }

    @DeleteMapping("/{questionId}")
    public String delete(@PathVariable int questionId){
        questionService.delete(questionId);
        return "문의글 삭제 완료";
    }
}








