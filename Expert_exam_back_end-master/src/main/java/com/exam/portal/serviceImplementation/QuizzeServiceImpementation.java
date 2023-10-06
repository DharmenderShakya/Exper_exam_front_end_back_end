package com.exam.portal.serviceImplementation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.Category;
import com.exam.portal.entity.Quizze;
import com.exam.portal.repository.QuizzeRepo;
import com.exam.portal.service.QuizzeService;

@Service
public class QuizzeServiceImpementation implements QuizzeService {

	@Autowired
	QuizzeRepo quizzeRepo;
	
	@Override
	public Quizze addQuizze(Quizze quize) {
		// TODO Auto-generated method stub
		return quizzeRepo.save(quize);
	}

	@Override
	public Quizze updateQuize(Quizze quize) {
		// TODO Auto-generated method stub
		return quizzeRepo.save(quize);
	}

	@Override
	public Set<Quizze> getAllQuize() {
		// TODO Auto-generated method stub
		return new LinkedHashSet(quizzeRepo.findAll());
	}

	@Override
	public Quizze getQuizeById(int id) {
		// TODO Auto-generated method stub
		return quizzeRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		quizzeRepo.deleteById(id);
	}

	@Override
	public List<Quizze> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return quizzeRepo.findBycategory(category);
	}

	@Override
	public List<Quizze> getActiveQuizzes() {
		// TODO Auto-generated method stub
		return quizzeRepo.findByActive(true);
	}

	@Override
	public List<Quizze> getActiveQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return quizzeRepo.findByCategoryAndActive(category, true);
	}

}
