package com.example.kursovaya2_hard.service;

import com.example.kursovaya2.exceptions.AmountVeryBigException;
import com.example.kursovaya2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > javaQuestionService.getAll().size()) {
            throw new AmountVeryBigException();
        }

        Set<Question> questionSet = new HashSet<>(amount);
        for (int i = 0; i < amount; i++) {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(questionSet);
    }
}
