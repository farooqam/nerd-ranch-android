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
    private Button buttonFalse;
    private Button buttonTrue;
    private QuizActivityState quizActivityState;
    private StateManager stateManager;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        stateManager = new StateManager();
        quizActivityState = stateManager.restoreState(bundle);

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

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        stateManager.saveState(bundle, quizActivityState);
    }

    private void updateQuestionText(){
        buttonTrue.setEnabled(true);
        buttonFalse.setEnabled(true);
        textViewQuestion.setText(questions.get(quizActivityState.getCurrentQuestionIndex()).getText());
    }

    private void checkAnswer(boolean trueButtonPressed) {
        buttonTrue.setEnabled(false);
        buttonFalse.setEnabled(false);

        boolean isCorrect;

        if(trueButtonPressed){
            isCorrect = answerService.answerIsCorrect(questions.get(quizActivityState.getCurrentQuestionIndex()), true);
        }
        else {
            isCorrect = answerService.answerIsCorrect(questions.get(quizActivityState.getCurrentQuestionIndex()), false);
        }

        if(isCorrect){
            toastService.showToast(getString(R.string.correct_answer));
        }
        else {
            toastService.showToast(getString(R.string.incorrect_answer));
        }

        quizActivityState.setCurrentQuestionIndex((quizActivityState.getCurrentQuestionIndex() + 1) % questions.size());

        TimedOperation.doAfter(2000, new DelayCallback() {
            @Override
            public void afterDelay() {
                updateQuestionText();
            }
        });
    }
}
