package com.example.studybuddy.studybuddy.realm;

import io.realm.RealmObject;

/**
 * Created by JohnNate on 6/12/17.
 */

public class Question extends RealmObject {

    private int id, answer;
    private String question;
    private String answerOne, AnswerTwo, AnswerThree, AnswerFour;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return AnswerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        AnswerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return AnswerThree;
    }

    public void setAnswerThree(String answerThree) {
        AnswerThree = answerThree;
    }

    public String getAnswerFour() {
        return AnswerFour;
    }

    public void setAnswerFour(String answerFour) {
        AnswerFour = answerFour;
    }
}
