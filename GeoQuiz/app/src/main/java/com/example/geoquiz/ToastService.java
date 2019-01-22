package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

class ToastService {

    private final AppCompatActivity activity;

    ToastService(AppCompatActivity activity) {

        this.activity = activity;
    }

    void showToast(String message) {
        Toast toast = Toast.makeText(this.activity,
                message,
                Toast.LENGTH_SHORT);

        toast.show();
    }
}
