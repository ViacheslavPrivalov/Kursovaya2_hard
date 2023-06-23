package com.example.kursovaya2_hard.repository;

import com.example.kursovaya2_hard.exceptions.NoSuchQuestionException;
import com.example.kursovaya2_hard.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        Question q1 = new Question("MathQuestion1", "MathAnswer1");
        Question q2 = new Question("MathQuestion2", "MathAnswer2");
        Question q3 = new Question("MathQuestion3", "MathAnswer3");
        Question q4 = new Question("MathQuestion4", "MathAnswer4");
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
    }
    @Override
    public Question add(String question, String answer) {

        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new NoSuchQuestionException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
