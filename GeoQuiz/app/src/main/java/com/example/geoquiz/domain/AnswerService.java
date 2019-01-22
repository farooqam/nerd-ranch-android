package com.example.geoquiz.domain;

public interface AnswerService {
    boolean answerIsCorrect(Question question, boolean answer);
}
