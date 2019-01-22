package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ToastServiceImpl implements ToastService {

    private final AppCompatActivity activity;

    ToastServiceImpl(AppCompatActivity activity) {

        this.activity = activity;
    }
    @Override
    public void showToast(String message) {
        Toast toast = Toast.makeText(this.activity,
                message,
                Toast.LENGTH_SHORT);

        toast.show();
    }
}
