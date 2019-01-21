package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button buttonTrue;
    private Button buttonFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);

        buttonTrue = findViewById(R.id.buttonTrue);

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(QuizActivity.this,
                        R.string.correct_answer,
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });

        buttonFalse = findViewById(R.id.buttonFalse);

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(QuizActivity.this,
                        R.string.incorrect_answer,
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });
    }
}
