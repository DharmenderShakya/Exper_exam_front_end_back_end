package com.exam.portal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import com.exam.portal.entity.Question;
import com.exam.portal.entity.Quizze;
import com.exam.portal.service.QuizzeService;
import com.exam.portal.serviceImplementation.QuestionCategoryServiceImplementation;

@RequestMapping("/question")
@RestController
public class QuestionController {

	@Autowired
	QuestionCategoryServiceImplementation questionCategoryServiceImplementation;
	
	@Autowired
	QuizzeService quizzeService;
	
	@PostMapping("/")
	public Question addQuestion(@RequestBody Question question) {
		
		return questionCategoryServiceImplementation.addQuestion(question);
	}
	
	@GetMapping("/")
	public Set<Question> getAllQuestion() {
		
		return questionCategoryServiceImplementation.getQuestion();
	}
	
	@PutMapping("/")
	public Question updateQuestion(@RequestBody Question question) {
		
		return questionCategoryServiceImplementation.updateQuestion(question); 
	}
	@GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") int qid) {
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quizze quiz = this.quizzeService.getQuizeById(qid);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestion())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
        
    }
	
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") int qid) {
        Quizze quiz = new Quizze();
        quiz.setqId(qid);
        Set<Question> questionsOfQuiz = this.questionCategoryServiceImplementation.getQuizeOfQuestion(quiz);
        return ResponseEntity.ok(questionsOfQuiz);

//        return ResponseEntity.ok(list);

    }

    //get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") int quesId) {
        return this.questionCategoryServiceImplementation.getQuestionById(quesId);
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") int quesId) {
        this.questionCategoryServiceImplementation.deleteById(quesId);
    }
	
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
        System.out.println(questions);
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;
        for (Question q : questions) {
            //single questions
            Question question = this.questionCategoryServiceImplementation.getQuestionById(q.getqId());
            if (question.getAnswer().equals(q.getAnswer())) {
                //correct
                correctAnswers++;

                double marksSingle = Double.parseDouble(questions.get(0).getQuizze().getMaxMarks()) / questions.size();
                //       this.questions[0].quiz.maxMarks / this.questions.length;
                marksGot += marksSingle;

            }

            if (q.getAnswer() != null) {
                attempted++;
            }

        }
        ;

        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
        return ResponseEntity.ok(map);

    }
}
