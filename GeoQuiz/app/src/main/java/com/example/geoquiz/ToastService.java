package com.example.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ToastService implements Toaster {

    private final AppCompatActivity activity;

    ToastService(AppCompatActivity activity) {

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
