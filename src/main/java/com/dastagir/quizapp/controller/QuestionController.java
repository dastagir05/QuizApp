package com.dastagir.quizapp.controller;

import com.dastagir.quizapp.entity.Question;
import com.dastagir.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{cat}")
    public List<Question> getQuestionByCategory(@PathVariable String cat){
        return questionService.getQuestionByCategory(cat);
    }

    @PostMapping("addquestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

}
