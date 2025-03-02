package com.kunal.QuizService.Controller;

import com.kunal.QuizService.Model.QuizDto;
import com.kunal.QuizService.Model.Questionwrapper;
import com.kunal.QuizService.Model.Response;
import com.kunal.QuizService.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumber(),quizDto.getTitle());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<Questionwrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable int id,@RequestBody List<Response> response){
        return quizService.getResult(id,response);
    }
}
