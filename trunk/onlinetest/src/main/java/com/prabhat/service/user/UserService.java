package com.prabhat.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prabhat.common.ContextProvider;
import com.prabhat.hibernate.dao.TestDao;
import com.prabhat.hibernate.dao.UserDao;
import com.prabhat.hibernate.entity.Role;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;
import com.prabhat.view.test.dto.UserTestDto;
import com.prabhat.view.user.dto.UserDto;

public class UserService {

	public List<UserClass> getAllUserClass() {
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		return userDao.getAllUserClass();
	}
	
	public void addUser(UserDto userDto, HttpServletRequest request) {
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		
		UserClass userClass = new UserClass();
		userClass.setId(userDto.getClassId());
		
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setMiddleName(userDto.getMiddleName());
		user.setLastName(userDto.getLastName());
		user.setUserClass(userClass);
		user.setLoginId(userDto.getFirstName().toLowerCase().trim());
		user.setPassword("123456");
		user.setRole(Role.USER);
		user.setSchool(loginUser.getSchool());
		user.setActive(Boolean.TRUE);
		userDao.addUser(user);
	}
	
	public List<User> findUsersOnSchool(HttpServletRequest request) {
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		return userDao.findUsersOnSchool(loginUser.getSchool());
	}
	
	public UserTestDto populateUserTestDto(UserTestDto userTestDto) {
		Long testId = userTestDto.getTestId();
		TestDao userDao = (TestDao)ContextProvider.gtApplicationContext().getBean("testDao");
		Test test = userDao.getTest(testId);
		userTestDto.setTestName(test.getName());
		userTestDto.setClassId(test.getTestClass().getId());
		userTestDto.setNoOfQuestion(test.getNoOfQuestion());
		userTestDto.setQuestionMarks(test.getQuestionMarks());
		userTestDto.setNegativeMarks(test.getNegativeMarks());
		userTestDto.setIsActive(test.getIsActive());
		return userTestDto;
	}
	
}
