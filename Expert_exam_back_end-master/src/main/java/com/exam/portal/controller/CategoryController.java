package com.exam.portal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.Category;
import com.exam.portal.serviceImplementation.CategoryServiceImplemention;

@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	CategoryServiceImplemention categoryServiceImplemention;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category cate= categoryServiceImplemention.addCategory(category);
		return ResponseEntity.ok(cate);
	}
	@GetMapping("/")
	public Set<Category> getCategory(){
		
		return categoryServiceImplemention.getAllCategory();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
		
		return categoryServiceImplemention.getCategoryById(id);
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		
		return categoryServiceImplemention.updateCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(int id) {
		
		categoryServiceImplemention.deleteById(id);
	}
	
}
