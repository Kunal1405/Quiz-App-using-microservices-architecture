package com.kunal.QuizService.Feign;

import com.kunal.QuizService.Model.Questionwrapper;
import com.kunal.QuizService.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="QUESTIONSERVICE",url = "http://localhost:8080")
public interface FeignInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numberOfQuestions);
    @PostMapping("question/getQuestions")
    public  ResponseEntity<List<Questionwrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds);
    @PostMapping("question/getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
