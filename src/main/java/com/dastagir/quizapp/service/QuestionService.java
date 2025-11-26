package com.dastagir.quizapp.service;

import com.dastagir.quizapp.dao.QuestionDao;
import com.dastagir.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String cat) {
        return questionDao.findByCategory(cat);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}
