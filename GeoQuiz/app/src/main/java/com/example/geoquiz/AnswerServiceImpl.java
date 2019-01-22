package com.example.geoquiz;

import com.example.geoquiz.domain.AnswerService;
import com.example.geoquiz.domain.Question;

public class AnswerServiceImpl implements AnswerService {
    @Override
    public boolean AnswerIsCorrect(Question question, boolean userAnswer) {
        return question.getAnswerIsTrue() == userAnswer;
    }
}
