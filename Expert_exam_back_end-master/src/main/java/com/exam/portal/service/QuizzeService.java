package com.exam.portal.service;

import java.util.List;
import java.util.Set;

import com.exam.portal.entity.Category;
import com.exam.portal.entity.Quizze;

public interface QuizzeService {
public Quizze addQuizze(Quizze quize);
public Quizze updateQuize(Quizze quize);
public Set<Quizze> getAllQuize();
public Quizze getQuizeById(int id);
public void deleteById(int id);

public List<Quizze> getQuizzesOfCategory(Category category);

public List<Quizze> getActiveQuizzes();

public List<Quizze> getActiveQuizzesOfCategory(Category category);
}
