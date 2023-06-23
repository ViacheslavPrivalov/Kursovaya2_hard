package com.example.kursovaya2_hard.repository;

import com.example.kursovaya2_hard.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
