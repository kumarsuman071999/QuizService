package com.quiz.controller;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping()
    ResponseEntity<String> save(@RequestBody Quiz quiz){
        quizService.add(quiz);
        return new  ResponseEntity<>("Added sussessfully", HttpStatus.CREATED);

    }
    @GetMapping()
    ResponseEntity<List<Quiz>> get(){
        List<Quiz>sav=quizService.get();
        return new ResponseEntity<>(sav,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Quiz> getone(@PathVariable Long id){
        return  new ResponseEntity<>(quizService.get(id),HttpStatus.FOUND);
    }
}
