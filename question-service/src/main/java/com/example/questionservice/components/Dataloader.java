package com.example.questionservice.components;


import com.example.questionservice.dao.QuestionDao;
import com.example.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

//    auto-wire my repos that I am using
//    this microservice needs question-db repo
    @Autowired
    QuestionDao questionDao;

    public Dataloader(){

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

//        make some questions
//        question 1
        Question question1 = new Question("What is the capital of France?", "London", "Paris", "Madrid", "Oslo", "Paris", "Easy", "Geography");
//        question 2
        Question question2 = new Question("What is the largest country in the world?", "United Kingdom", "Russia", "China", "Botswana", "Russia", "Easy", "Geography");
//        question 3
        Question question3 = new Question("How many legs does a spider have?", "8", "2", "6", "10", "8", "Easy", "Animals");
//        question 4
        Question question4 = new Question("What is the largest animal in the world?", "Lion", "Elephant", "Frog", "Whale", "Whale", "Easy", "Animals");

//        questions 5
//        questions 6
//        questions 7
//        questions 8
//        questions 9
//        questions 10
//        questions 11
//        questions 12


//        add the questions to the question database

        questionDao.deleteAll(); //this is a short fix => need to find out how to wipe my db before re-populating.
//        this fix does delete the questions, but the id of the questions increase, meaning the db is still populated.
        questionDao.save(question1);
        questionDao.save(question2);
        questionDao.save(question3);
        questionDao.save(question4);
    }
}
