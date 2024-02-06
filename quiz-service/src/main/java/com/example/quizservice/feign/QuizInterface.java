package com.example.quizservice.feign;

import com.example.quizservice.model.QuestionWrapper;
import com.example.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Feign will help the quiz service interact the question service
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
//    DECLARE (not define) which methods, of the service we are accessing, that we want

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numberOfQuestions);


    //    getQuestionById - this will be a PostMapping
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> questionIds);


    //    getScore - this is a postMapping
    @PostMapping("qetScore")
    public ResponseEntity<Integer> getScore (@RequestBody List<Response> responses);
}
