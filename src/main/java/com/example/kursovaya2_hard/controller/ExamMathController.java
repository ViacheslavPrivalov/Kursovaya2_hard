package com.example.kursovaya2_hard.controller;

import com.example.kursovaya2_hard.model.Question;
import com.example.kursovaya2_hard.service.ExaminerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class ExamMathController {
    private final ExaminerService service;

    public ExamMathController(@Qualifier("examinerMathService") ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {

        return service.getQuestions(amount);
    }

}
