package com.example.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geoquiz.domain.AnswerService;
import com.example.geoquiz.domain.Question;
import com.example.geoquiz.domain.QuestionRepository;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private ToastService toastService;
    private List<Question> questions;
    private AnswerService answerService;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        toastService = new ToastService(QuizActivity.this);
        answerService = new AnswerServiceImpl();

        QuestionRepository questionRepository = new InMemoryQuestionRepository();
        questions = questionRepository.GetQuestions();

        textViewQuestion = findViewById(R.id.textViewQuestion);
        updateQuestionText();

        Button buttonTrue = findViewById(R.id.buttonTrue);

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        Button buttonFalse = findViewById(R.id.buttonFalse);

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        Button buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
                updateQuestionText();
            }
        });
    }

    private void updateQuestionText(){
        textViewQuestion.setText(questions.get(currentQuestionIndex).getText());
    }

    private void checkAnswer(boolean trueButtonPressed) {
        boolean isCorrect;

        if(trueButtonPressed){
            isCorrect = answerService.AnswerIsCorrect(questions.get(currentQuestionIndex), true);
        }
        else {
            isCorrect = answerService.AnswerIsCorrect(questions.get(currentQuestionIndex), false);
        }

        if(isCorrect){
            toastService.showToast(getString(R.string.correct_answer));
        }
        else {
            toastService.showToast(getString(R.string.incorrect_answer));
        }
    }
}
