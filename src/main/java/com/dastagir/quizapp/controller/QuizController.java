package com.dastagir.quizapp.controller;

import com.dastagir.quizapp.entity.QuestionWrapper;
import com.dastagir.quizapp.entity.Response;
import com.dastagir.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

        return quizService.createQuiz(category, numQ, title);

    }

    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submintQuiz(@PathVariable Integer id, @RequestBody List<Response> response ){
        return quizService.calculateResult(id, response);
    }
}
