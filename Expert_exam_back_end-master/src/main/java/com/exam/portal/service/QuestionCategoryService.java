package com.exam.portal.service;

import java.util.Set;

import com.exam.portal.entity.Question;
import com.exam.portal.entity.Quizze;

public interface QuestionCategoryService {
public Question addQuestion(Question question);
public Question updateQuestion(Question question);
public Set<Question> getQuestion();
public Set<Question> getQuizeOfQuestion(Quizze question);
public Question getQuestionById(int id);
public void deleteById(int id);
}
