package com.exam.portal.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int CId;
private String title;
private String description;

@OneToMany(cascade = CascadeType.ALL)
private Set<Quizze> quizzes=new LinkedHashSet<>();

public int getCId() {
	return CId;
}
public void setCId(int cId) {
	CId = cId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Set<Quizze> getQuizzes() {
	return quizzes;
}
public void setQuizzes(Set<Quizze> quizzes) {
	this.quizzes = quizzes;
}

}
