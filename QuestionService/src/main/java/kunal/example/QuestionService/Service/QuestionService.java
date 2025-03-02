package kunal.example.QuestionService.Service;

import kunal.example.QuestionService.Model.Questions;
import kunal.example.QuestionService.Model.Questionwrapper;
import kunal.example.QuestionService.Model.Response;
import kunal.example.QuestionService.Repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepo repo;
    public ResponseEntity<List<Questions>> getAllQuestion() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Questions>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try{
            repo.save(question);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed",HttpStatus.NOT_ACCEPTABLE);

        }
    }

    public ResponseEntity<String> updateQuestion(int id, Questions response) {
        Optional<Questions> existingQuestion = repo.findById(id);

        if (existingQuestion.isPresent()) {
            Questions questionToUpdate = existingQuestion.get();
            questionToUpdate.setQuestion(response.getQuestion());
            questionToUpdate.setOption1(response.getOption1());
            questionToUpdate.setOption2(response.getOption2());
            questionToUpdate.setOption3(response.getOption3());
            questionToUpdate.setOption4(response.getOption4());
            questionToUpdate.setRightAnswer(response.getRightAnswer());
            questionToUpdate.setDifficultyLevel(response.getDifficultyLevel());
            questionToUpdate.setCategory(response.getCategory());

            repo.save(questionToUpdate);
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            repo.deleteById(id);
            return new ResponseEntity<>("Successfully Deleted",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsFroQuiz(String category, int numberOfQuestions) {
        List<Integer> questions=repo.findRandomQuestions(category,numberOfQuestions);
        return  new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<Questionwrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<Questionwrapper>wrappers=new ArrayList<>();
        List<Questions>questions=new ArrayList<>();
      try{  for(Integer questionid:questionIds){
            questions.add(repo.findById(questionid).get());
        }
        for(Questions question:questions){
            Questionwrapper wrapper=new Questionwrapper();
            wrapper.setId(question.getId());
             wrapper.setQuestion(question.getQuestion());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption4());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);}
      catch (Exception e){
          return  new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
      }
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right=0;
        for(Response response:responses){
            Questions question=repo.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer())){
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
