package com.kunal.QuizService.Model;

public class QuizDto {
   private int number;
   private String category;
   private String title;

    public int getNumber() {
        return number;
    }

    public void setId(int number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public QuizDto() {

    }
}
