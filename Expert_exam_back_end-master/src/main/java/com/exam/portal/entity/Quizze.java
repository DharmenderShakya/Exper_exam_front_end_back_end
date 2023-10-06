package com.exam.portal.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quizze {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int qId;
private String title;
private String description;
private String maxMarks;
private String numberOfQuestion;
private boolean active=false;

@ManyToOne(fetch = FetchType.EAGER)
private Category category;

@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JsonIgnore
private Set<Question> questions=new HashSet<>();

public int getqId() {
	return qId;
}
public void setqId(int qId) {
	this.qId = qId;
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
public String getMaxMarks() {
	return maxMarks;
}
public void setMaxMarks(String maxMarks) {
	this.maxMarks = maxMarks;
}
public String getNumberOfQuestion() {
	return numberOfQuestion;
}
public void setNumberOfQuestion(String numberOfQuestion) {
	this.numberOfQuestion = numberOfQuestion;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Set<Question> getQuestions() {
	return questions;
}
public void setQuestions(Set<Question> questions) {
	this.questions = questions;
}


}
