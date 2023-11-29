package com.quiz.service;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {


    QuizRepository quizRepository;

    QuestionClient questionClient;

    public QuizService(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    //save
    public Quiz add(Quiz quiz){
        return quizRepository.save(quiz);
    }

    public List<Quiz> get(){
        List<Quiz> qizzess= quizRepository.findAll();
        List<Quiz> newQizList=qizzess.stream().map(quiz->{
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQizList;
    }

    public Quiz get(Long id){
        Quiz quiz= quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not Found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return  quiz;

    }
}
