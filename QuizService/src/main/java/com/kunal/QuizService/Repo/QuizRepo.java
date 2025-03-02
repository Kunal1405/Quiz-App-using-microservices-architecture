package com.kunal.QuizService.Repo;

import com.kunal.QuizService.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
