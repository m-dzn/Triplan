package com.triplan.controller.api;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.service.inf.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class ApiQuestionController {

    private final QuestionService questionService;

    @PostMapping
    public String register(@RequestBody QuestionVO questionVO) {
        questionService.create(questionVO);
        System.out.println(" C : Create 실행");
        return "board/list";
    }

    @GetMapping("/{questionId}")
    public QuestionVO getQuestion(@PathVariable int questionId) {
        System.out.println(" C : getQ 실행@@@@@@@@@@@@");

        return questionService.getQuestion(questionId);
    }

    @PutMapping("/{questionId}")
    public String update(@PathVariable Integer questionId, @RequestBody QuestionVO questionVO) {
        questionService.update(questionId, questionVO);
        return "수정 완료";
    }

    @DeleteMapping("/{questionId}")
    public String delete(@PathVariable Integer questionId) {
        questionService.delete(questionId);
        return "문의글 삭제 완료";
    }

    @GetMapping("/itemGroups/{itemGroupId}")
    public List<QuestionDTO> questionList(@PathVariable Integer itemGroupId) {
        return questionService.questionList(itemGroupId);
    }

    @GetMapping("/sellers/{sellerId}")
    public List<QuestionVO> questionListBySellerId(@PathVariable Integer sellerId) {
        return questionService.questionListBySellerId(sellerId);
    }

    @GetMapping("/sellers/{itemGroupId}")
    public List<QuestionVO> questionListByItemGId(@PathVariable Integer itemGroupId) {
        return questionService.questionListByItemGId(itemGroupId);
    }

    @GetMapping("/members/{memberId}")
    public List<QuestionVO> questionLIstByMemberId(@PathVariable Integer memberId) {
        return questionService.questionListByMemberId(memberId);

    }

    @GetMapping
    public Pagination<QuestionVO> questionList(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage)
    {
        return questionService.list(pageSize, currentPage);
    }

}








