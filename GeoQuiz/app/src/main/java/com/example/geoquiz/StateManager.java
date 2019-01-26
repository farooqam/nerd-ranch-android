package com.example.geoquiz;

import android.os.Bundle;

import java.io.Serializable;

class StateManager {
    QuizActivityState restoreState(Bundle bundle) {
        if(bundle == null) {
            return  new QuizActivityState();
        }

        Serializable state = bundle.getSerializable(QuizActivityState.Key);

        if(state != null) {
            return (QuizActivityState)state;
        }

        return new QuizActivityState();
    }

    void saveState(Bundle bundle, QuizActivityState state) {
        bundle.putSerializable(QuizActivityState.Key, state);
    }
}
