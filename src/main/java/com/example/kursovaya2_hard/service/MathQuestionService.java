package com.example.kursovaya2_hard.service;

import com.example.kursovaya2_hard.exceptions.NoSuchQuestionException;
import com.example.kursovaya2_hard.model.Question;
import com.example.kursovaya2_hard.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(repository.getAll());
        return questionList.get(random.nextInt(repository.getAll().size()));
    }
}
