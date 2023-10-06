package com.exam.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.portal.entity.Category;
import com.exam.portal.entity.Quizze;

@Repository
public interface QuizzeRepo extends JpaRepository<Quizze, Integer> {
	
	public List<Quizze> findBycategory(Category category);

    public List<Quizze> findByActive(Boolean b);

    public List<Quizze> findByCategoryAndActive(Category c, Boolean b);

}
