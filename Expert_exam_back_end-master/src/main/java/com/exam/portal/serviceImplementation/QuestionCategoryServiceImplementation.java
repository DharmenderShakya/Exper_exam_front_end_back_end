package com.exam.portal.serviceImplementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.Question;
import com.exam.portal.entity.Quizze;
import com.exam.portal.repository.QuestionRepo;
import com.exam.portal.service.QuestionCategoryService;

@Service
public class QuestionCategoryServiceImplementation implements QuestionCategoryService{

	@Autowired
	QuestionRepo questionRep;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRep.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRep.save(question);
	}

	@Override
	public Set<Question> getQuestion() {
		
		return new LinkedHashSet(questionRep.findAll());
	}

	@Override
	public Set<Question> getQuizeOfQuestion(Quizze quize) {
		// TODO Auto-generated method stub
		return questionRep.findByQuizze(quize);
	}

	@Override
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		return questionRep.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		questionRep.deleteById(id);
	}
	
	
}
