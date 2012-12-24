package com.prabhat.view.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.User;
import com.prabhat.service.test.TestService;
import com.prabhat.view.question.dto.UserQuestionDto;
import com.prabhat.view.user.dto.UserDto;

public class StudentAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7980196168893504854L;
	
	private UserDto userDto;
	private UserQuestionDto questionDto;
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("actionName");
		if (action == null) {
			action = getQuestionDto().getActionName();
		}
		if (action != null && action.equals("showStudentTest")) {
			return showStudentTest();
		} if (action != null && action.equals("submitPaper")) {
			return submitPaper();
		} else {
			return showStudentTestStatus();
		}
		
	}
	
	private String showStudentTestStatus() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		TestService testService = new TestService();
		List<Test> tests = testService.getUnAttempedTest(loginUser.getId());
		getUserDto().setPendingTestList(tests);
		return "studentpage";
	}
	
	private String showStudentTest() {
		TestService testService = new TestService();
		getQuestionDto().setQuestionList(testService.getQuestionsOnTest(getQuestionDto().getTestId()));
		return "studentpaper";
	}
	
	private String submitPaper() {
		TestService testService = new TestService();
		HttpServletRequest request = ServletActionContext.getRequest();
		testService.addUserTestAns(getQuestionDto(), request);
		return showStudentTestStatus();
	}
	//

	/**
	 * @return the userDto
	 */
	public UserDto getUserDto() {
		if (userDto == null) {
			userDto = new UserDto();
		}
		return userDto;
	}

	/**
	 * @param userDto the userDto to set
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	/**
	 * @return the questionDto
	 */
	public UserQuestionDto getQuestionDto() {
		if (questionDto == null) {
			questionDto = new UserQuestionDto();
		}
		return questionDto;
	}

	/**
	 * @param questionDto the questionDto to set
	 */
	public void setQuestionDto(UserQuestionDto questionDto) {
		this.questionDto = questionDto;
	}
}
