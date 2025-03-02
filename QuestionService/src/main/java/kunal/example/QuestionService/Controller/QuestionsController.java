package kunal.example.QuestionService.Controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import kunal.example.QuestionService.Model.Questions;
import kunal.example.QuestionService.Model.Questionwrapper;
import kunal.example.QuestionService.Model.Response;
import kunal.example.QuestionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<Questions>>getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("allquestions/{category}")
    public ResponseEntity<List<Questions>> getByCategory(@PathVariable String category){
        return questionService.getByCategory(category);
    }
    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
    @PostMapping("updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id,@RequestBody Questions response){
        return questionService.updateQuestion(id,response);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam int numberOfQuestions){
        return  questionService.getQuestionsFroQuiz(category,numberOfQuestions);
    }
    @PostMapping("/getQuestions")
    public  ResponseEntity<List<Questionwrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }
    @PostMapping("/getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return  questionService.getScore(responses);
    }
}
