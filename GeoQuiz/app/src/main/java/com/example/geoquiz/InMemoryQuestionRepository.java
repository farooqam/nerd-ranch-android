package com.example.geoquiz;

import com.example.geoquiz.domain.Question;
import com.example.geoquiz.domain.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuestionRepository implements QuestionRepository {
    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Alaska is the least populated state in the United States.",
                false));

        questions.add(new Question(
                "The Pacific Ocean is larger than the Atlantic Ocean.",
                true));

        questions.add(new Question(
                "The Suez Canal connects the Red Sea to the Indian Ocean.",
                false));

        questions.add(new Question(
                "Djbouti is the capital of Djbouti.",
                true));

        questions.add(new Question(
                "Lake Baikal in Russia is the deepest lake in the world.",
                true));

        return questions;
    }
}
