package com.exam.portal.serviceImplementation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.Category;
import com.exam.portal.repository.CategoryRepo;
import com.exam.portal.service.CategoryService;

@Service
public class CategoryServiceImplemention implements CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepo.save(category);
	}

	@Override
	public Set<Category> getAllCategory() {
		
		return new LinkedHashSet(categoryRepo.findAll());
	}

	@Override
	public Category getCategoryById(int id) {
		
		return categoryRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		categoryRepo.deleteById(id);
		
	}

}
