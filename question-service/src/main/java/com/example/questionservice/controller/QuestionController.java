package com.example.questionservice.controller;


import com.example.questionservice.model.Question;
import com.example.questionservice.model.QuestionWrapper;
import com.example.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

//    need these requests to make it not dependent on the qizz service
//    generate - this will be a GetMapping request
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numberOfQuestions){
//        what are we returning here?- we want to return the IDs of the questions
        return questionService.getQuestionForQuiz(categoryName, numberOfQuestions);
    }


//    getQuestionById - this will be a PostMapping
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionById(questionIds);
    }


//    getScore


}
