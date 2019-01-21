package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button buttonTrue;
    private Button buttonFalse;
    private Toaster toastService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        toastService = new ToastService(QuizActivity.this);

        buttonTrue = findViewById(R.id.buttonTrue);

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastService.showToast(R.string.correct_answer);
            }
        });

        buttonFalse = findViewById(R.id.buttonFalse);

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastService.showToast(R.string.incorrect_answer);
            }
        });
    }
}
