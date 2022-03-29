package com.ita.filmquiz;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String text = null;
    private Boolean answer;

    public Question() {
    }

    public Question(String text, Boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answer=" + answer +
                '}';
    }
}
