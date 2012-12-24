package com.prabhat.service.question;

import java.util.List;

import com.prabhat.common.ContextProvider;
import com.prabhat.hibernate.dao.TestDao;
import com.prabhat.hibernate.entity.Question;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.view.question.dto.UserQuestionDto;

public class QuestionService {
	
	public List<Question> getQuestions(Long testId) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		return userDao.getQuestions(testId);
	}
	
	public Question getQuestion(Long questionId) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		return userDao.getQuestion(questionId);
	}
	
	public void saveQuestion(UserQuestionDto userQuestionDto) {
		Question question = new Question();
		question.setName(userQuestionDto.getQuestionName());
		question.setOptA(userQuestionDto.getOptA());
		question.setOptB(userQuestionDto.getOptB());
		question.setOptC(userQuestionDto.getOptC());
		question.setOptD(userQuestionDto.getOptD());
		question.setOptE(userQuestionDto.getOptE());
		question.setOptAns(userQuestionDto.getOptAns());
		Test test = new Test();
		test.setId(userQuestionDto.getTestId());
		question.setTest(test);
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		userDao.saveQuestion(question);
	}
	
	
}
