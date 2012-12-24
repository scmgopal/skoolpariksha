package com.prabhat.service.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prabhat.common.ContextProvider;
import com.prabhat.hibernate.dao.TestDao;
import com.prabhat.hibernate.entity.Question;
import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;
import com.prabhat.hibernate.entity.UserTestAns;
import com.prabhat.view.question.dto.UserQuestionDto;
import com.prabhat.view.test.dto.UserTestDto;

public class TestService {

	public void addTest(UserTestDto userTestDto, HttpServletRequest request) {
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		Test test = new Test();
		if (userTestDto.getTestId() != null) {
			test.setId(userTestDto.getTestId());
		}
		test.setName(userTestDto.getTestName());
		test.setSchool(loginUser.getSchool());
		
		UserClass testClass = new UserClass();
		testClass.setId(userTestDto.getClassId());
		test.setTestClass(testClass);
		
		test.setNoOfQuestion(userTestDto.getNoOfQuestion());
		test.setQuestionMarks(userTestDto.getQuestionMarks());
		test.setNegativeMarks(userTestDto.getNegativeMarks());
		test.setIsActive(userTestDto.getIsActive());
		
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		userDao.addTest(test);
	}
	
	public List<Test> getTestsOnSchool(School school) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		return userDao.getTestsOnSchool(school);
	}
	public List<Test> getUnAttempedTest(Long userId) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		return userDao.getUnAttempedTest(userId);
	}
	
	public List<Question> getQuestionsOnTest(Long testId) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		return userDao.getQuestions(testId);
	}
	
	public void addUserTestAns(UserQuestionDto questionDto, HttpServletRequest request) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		UserTestAns userTestAns = null;
		List<UserTestAns> userTestAnsList = null;
		String[] userAnswer = questionDto.getStudentChoice();
		if (userAnswer != null && userAnswer.length>0) {
			userTestAnsList = new ArrayList<UserTestAns>();
			for (String string : userAnswer) {
				if (!string.equals("-1")) {
					String questionId = string.split("-")[0];
					String answer = string.split("-")[1];
					userTestAns = new UserTestAns();
					userTestAns.setUserId(loginUser.getId());
					userTestAns.setTestId(questionDto.getTestId());
					userTestAns.setQuestionId(new Long(questionId));
					userTestAns.setAnswer(answer);
					userTestAnsList.add(userTestAns);
				}
			}
		}
		if (userTestAnsList != null) {
			userDao.updateUserTest(loginUser.getId(), questionDto.getTestId());
			userDao.saveAllUserTestAns(userTestAnsList);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		Test test = userDao.getTest(1L);
		System.out.println(test.getName());
	}

}
