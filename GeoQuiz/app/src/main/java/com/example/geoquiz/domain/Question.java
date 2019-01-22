package com.example.geoquiz.domain;

public class Question {
    private final String text;
    private final boolean answerIsTrue;

    public Question(String text, boolean answerIsTrue) {

        this.text = text;
        this.answerIsTrue = answerIsTrue;
    }

    public String getText() {
        return text;
    }

    public boolean getAnswerIsTrue() {
        return answerIsTrue;
    }
}
