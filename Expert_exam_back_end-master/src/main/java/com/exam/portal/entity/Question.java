package com.exam.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int qId;
private String image;
private String content;
private String optionl;
private String option2;
private String option3;
private String option4;

private String answer;
private String giveAnswer;

@ManyToOne(fetch = FetchType.EAGER)
private Quizze quizze;

public int getqId() {
	return qId;
}
public void setqId(int qId) {
	this.qId = qId;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getOptionl() {
	return optionl;
}
public void setOptionl(String optionl) {
	this.optionl = optionl;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getGiveAnswer() {
	return giveAnswer;
}
public void setGiveAnswer(String giveAnswer) {
	this.giveAnswer = giveAnswer;
}
public Quizze getQuizze() {
	return quizze;
}
public void setQuizze(Quizze quizze) {
	this.quizze = quizze;
}


}
