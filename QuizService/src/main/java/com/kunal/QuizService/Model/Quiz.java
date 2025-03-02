package com.kunal.QuizService.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ElementCollection
    private List<Integer> questionsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(List<Integer> questionsId) {
        this.questionsId = questionsId;
    }
}
