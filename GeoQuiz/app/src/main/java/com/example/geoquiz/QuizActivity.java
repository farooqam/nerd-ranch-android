package com.example.geoquiz;

import android.os.Bundle;
import android.os.Handler;
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
    private Button buttonFalse;
    private Button buttonTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        buttonTrue = findViewById(R.id.buttonTrue);
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        buttonFalse = findViewById(R.id.buttonFalse);
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        toastService = new ToastService(QuizActivity.this);
        answerService = new AnswerServiceImpl();

        QuestionRepository questionRepository = new InMemoryQuestionRepository();
        questions = questionRepository.getQuestions();

        textViewQuestion = findViewById(R.id.textViewQuestion);
        updateQuestionText();

    }

    private void updateQuestionText(){
        buttonTrue.setEnabled(true);
        buttonFalse.setEnabled(true);
        textViewQuestion.setText(questions.get(currentQuestionIndex).getText());
    }

    private void checkAnswer(boolean trueButtonPressed) {
        buttonTrue.setEnabled(false);
        buttonFalse.setEnabled(false);

        boolean isCorrect;

        if(trueButtonPressed){
            isCorrect = answerService.answerIsCorrect(questions.get(currentQuestionIndex), true);
        }
        else {
            isCorrect = answerService.answerIsCorrect(questions.get(currentQuestionIndex), false);
        }

        if(isCorrect){
            toastService.showToast(getString(R.string.correct_answer));
        }
        else {
            toastService.showToast(getString(R.string.incorrect_answer));
        }

        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
        int delay = 3000;
        delay(delay, new DelayCallback() {
            @Override
            public void afterDelay() {
                updateQuestionText();
            }
        });
    }

    private void delay(int milliseconds, final DelayCallback delayCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, milliseconds);
    }
}
