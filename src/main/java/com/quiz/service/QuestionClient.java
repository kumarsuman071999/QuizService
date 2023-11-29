package com.quiz.service;

import com.quiz.entity.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url="http://localhost:9090",value ="Question-Client" )
@FeignClient(name="QUESTION-SERVICE")
//QUESTION-SERVICE from eurka server application name
public interface QuestionClient {

    // craete method to call getQuestionOfQuiz from Oestion controller
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
