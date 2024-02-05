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
//        geo - 4
//        animals - 4
//        music - 4

//        question 1
        Question question1 = new Question("What is the capital of France?", "London", "Paris", "Madrid", "Oslo", "Paris", "Easy", "Geography");

//        question 2
        Question question2 = new Question("What is the largest country in the world?", "United Kingdom", "Russia", "China", "Botswana", "Russia", "Easy", "Geography");

//        question 3
        Question question3 = new Question("How many legs does a spider have?", "8", "2", "6", "10", "8", "Easy", "Animals");

//        question 4
        Question question4 = new Question("What is the largest animal in the world?", "Lion", "Elephant", "Frog", "Whale", "Whale", "Easy", "Animals");

//        questions 5
        Question question5 = new Question("What is the smallest country in the world?", "Vatican City", "Luxembourg", "Monaco", "Bahrain", "Vatican City", "Medium", "Geography");

//        questions 6
        Question question6 = new Question("Who make the hit song 'Smooth Criminal'?", "Taylor Swift", "Beyonce", "Prince", "Micheal Jackson", "Micheal Jackson", "Easy", "Music");

//        questions 7
        Question question7 = new Question("Which of the following countries is a landlocked country?", "Kenya", "Austria", "Belgium", "Gambia", "Austria", "Medium", "Geography");

//        questions 8
        Question question8 = new Question("Which animal is known for having the most powerful bite?", "Hippopotamus", "Lion", "Crocodile", "Dog", "Hippopotamus", "Difficult", "Animals");

//        questions 9
        Question question9 = new Question("A dog sweats through which part of its body?", "Tongue", "Paw", "Back", "Ears", "Paw", "Difficult", "Animals");

//        questions 10
        Question question10 = new Question("Which official World Cup song did Shakira release in 2010?", "Hips dont lie", "She wolf", "Waka Waka", "Whenever, Wherever", "Waka Waka", "Easy", "Music");

//        questions 11
        Question question11 = new Question("Beyoncé’s 2016 album shares its name with which sweet drink?", "Lemonade", "Coco-Cola", "Tropical Juice", "7Up", "Lemonade", "Easy", "Music");

//        questions 12
        Question question12 = new Question("Which band released the big hit 'We will rock you?", "Rolling Stones", "Queen", "Beatles", "Take That", "Queen", "Medium", "Music");


//        add the questions to the question database

        questionDao.deleteAll(); //this is a short fix => need to find out how to wipe my db before re-populating.
//        this fix does delete the questions, but the id of the questions increase, meaning the db is still populated.
        questionDao.save(question1);
        questionDao.save(question2);
        questionDao.save(question3);
        questionDao.save(question4);
        questionDao.save(question5);
    }
}
