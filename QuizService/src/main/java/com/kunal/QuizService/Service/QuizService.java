package com.kunal.QuizService.Service;
import com.kunal.QuizService.Repo.QuizRepo;
import com.kunal.QuizService.Feign.FeignInterface;
import com.kunal.QuizService.Model.Questionwrapper;
import com.kunal.QuizService.Model.Quiz;
import com.kunal.QuizService.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;


    @Autowired
    FeignInterface feignInterface;
    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
        List<Integer> questionIds=feignInterface.getQuestionsForQuiz(category,noQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsId(questionIds);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Questionwrapper>> getQuizQuestions(int id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Integer>questions=quiz.getQuestionsId();
        System.out.println(questions);
//        try{
//      ResponseEntity <List<Questionwrapper>> questionForUser=feignInterface.getQuestionsFromId(questions);
//      return questionForUser;
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        ResponseEntity <List<Questionwrapper>> questionForUser=feignInterface.getQuestionsFromId(questions);
      return questionForUser;
    }

    public ResponseEntity<Integer> getResult(int id, List<Response> response) {
        int right=feignInterface.getScore(response).getBody();
        return new ResponseEntity<>(right,HttpStatus.ACCEPTED);
    }
}
