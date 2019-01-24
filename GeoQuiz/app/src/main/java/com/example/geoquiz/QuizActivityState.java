package com.example.geoquiz;

import java.io.Serializable;

class QuizActivityState implements Serializable {
    private int currentQuestionIndex = 0;

    void setCurrentQuestionIndex(int value) {
        currentQuestionIndex = value;
    }

    int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    static final String Key = "quizActivityState";

}
