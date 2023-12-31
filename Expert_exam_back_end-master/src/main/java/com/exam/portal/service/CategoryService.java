package com.exam.portal.service;

import java.util.Set;

import com.exam.portal.entity.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getAllCategory();
	
	public Category getCategoryById(int id);
	
	public void deleteById(int id);
		
}
