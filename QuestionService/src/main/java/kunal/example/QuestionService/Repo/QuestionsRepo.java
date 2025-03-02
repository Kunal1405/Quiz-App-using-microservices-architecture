package kunal.example.QuestionService.Repo;

import kunal.example.QuestionService.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions,Integer> {
     List<Questions> findByCategory(String cateogry);
     @Query(value = "SELECT q.id FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :noQ", nativeQuery = true)
     List<Integer> findRandomQuestions(@Param("category") String category, @Param("noQ") int noQ);

}
