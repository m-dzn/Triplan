package com.triplan.controller.api;


import com.triplan.domain.AnswerVO;
import com.triplan.service.inf.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class ApiAnswerController {

    private final AnswerService answerService;

    @PostMapping
    public String register(@RequestBody AnswerVO answerVO){
        answerService.register(answerVO);
        return "답변 작성 성공";
    }

    @GetMapping("/{questionId}")
    public AnswerVO getAnswer(@PathVariable Integer questionId){
        return answerService.getAnswer(questionId);
    }

    @PutMapping("/{questionId}")
    public String update(@PathVariable Integer questionId, @RequestBody AnswerVO answerVO){
        answerService.update(questionId, answerVO);
        return "답변 수정 완료";
    }

    @DeleteMapping("/{questionId}")
    public String delete(@PathVariable Integer questionId){
        answerService.delete(questionId);
        return "답변 삭제 완료";
    }



}
