package com.prabhat.hibernate.dao;

import java.util.List;

import com.prabhat.hibernate.entity.Question;
import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.UserTestAns;

public interface TestDao {
	void addTest(Test test);
	Test getTest(Long testId);
	List<Test> getTestsOnSchool(School school);
	List<Question> getQuestions(Long testId);
	
	Question getQuestion(Long questionId);
	
	void saveQuestion(Question question);
	List<Test> getUnAttempedTest(Long userId);
	void saveAllUserTestAns(List<UserTestAns> userTestAnsList);
	
	void updateUserTest(Long userId, Long testId) ;
}

