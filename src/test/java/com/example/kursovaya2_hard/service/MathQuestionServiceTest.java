package com.example.kursovaya2_hard.service;

import com.example.kursovaya2_hard.model.Question;
import com.example.kursovaya2_hard.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    private final QuestionRepository repositoryMock = mock(QuestionRepository.class);
    private MathQuestionService out;

    private final Question q = new Question("q", "a");

    private static Collection<Question> questions = Set.of(
            new Question("question", "answer"),
            new Question("Question", "Answer"),
            new Question("Quest", "Ans")
    );

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("question?", "answer!"),
                Arguments.of("q", "a"),
                Arguments.of(" ", " ")
        );
    }

    @BeforeEach
    public void initOut() {
        out = new MathQuestionService(repositoryMock);
        when(repositoryMock.add(anyString(), anyString())).thenReturn(q);
        when(repositoryMock.add(any())).thenReturn(q);
        when(repositoryMock.remove(any())).thenReturn(q);
        when(repositoryMock.getAll()).thenReturn(questions);
    }

    @ParameterizedTest
    @MethodSource("params")
    public void shouldReturnQuestion(String question, String answer) {
        Question actual = out.add(question, answer);
        assertEquals(actual, q);

        assertEquals(out.add(new Question(question, answer)), q);
        assertEquals(out.remove(new Question(question, answer)), q);
    }

    @Test
    public void shouldReturnCollection() {
        assertEquals(out.getAll(), questions);
        assertEquals(out.getAll().size(), 3);
    }

    @Test
    public void randomQuestionTest() {
        assertNotNull(out.getRandomQuestion());
        assertTrue(questions.contains(out.getRandomQuestion()));
    }

}
