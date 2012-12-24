package com.prabhat.view.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;
import com.prabhat.service.test.TestService;
import com.prabhat.service.user.UserService;
import com.prabhat.view.test.dto.UserTestDto;

public class UserTest extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4494771144026907295L;
	private  UserTestDto userTestDto;

		public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("actionName");
		if (action == null) {
			action = getUserTestDto().getActionName();
		}
		if (action != null && action.equals("addTestView")) {
			return addTestView();
		}
		else if (action != null && action.equals("addTest")) {
			return addTest();
		}else if (action != null && action.equals("editTestView")) {
			return editTestView();
		} else {
			return showUserTestPage();
		}
	}
	
	private String showUserTestPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		TestService testService = new TestService();
		User currentUser = (User)request.getSession().getAttribute("loginUser");
		List<Test> tests = testService.getTestsOnSchool(currentUser.getSchool());
		getUserTestDto().setTests(tests);
		return "userTestPage";
	}
	
	private String addTestView() {
		UserService userService = new UserService();
		List<UserClass> userClasses = userService.getAllUserClass();
		getUserTestDto().setUserClasses(userClasses);
		return "addtestpage";
	}
	
	private String editTestView() {
		UserService userService = new UserService();
		userService.populateUserTestDto(getUserTestDto());
		List<UserClass> userClasses = userService.getAllUserClass();
		getUserTestDto().setUserClasses(userClasses);
		return "addtestpage";
	}
	
	
	
	private String addTest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		TestService testService = new TestService();
		testService.addTest(getUserTestDto(), request);
		return showUserTestPage();
	}
	
	public void validate() {
		if (getUserTestDto().getActionName() != null && getUserTestDto().getActionName().equals("addTest")) {
			if ( getUserTestDto().getTestName().trim().length() == 0 ){	
				addFieldError("userTestDto.testName", "Test name is required." );
			}
			
			if ( getUserTestDto().getClassId() == -1 ){	
				addFieldError("userTestDto.classId", "Class is required." );
			}
			
			if (getUserTestDto().getNoOfQuestion() == null || getUserTestDto().getNoOfQuestion() == -1 ){	
				addFieldError("userTestDto.noOfQuestion", "Number of question is required." );
			}
			
			if (getUserTestDto().getQuestionMarks() == null || getUserTestDto().getQuestionMarks() == -1 ){	
				addFieldError("userTestDto.questionMarks", "Marks For each question is required." );
			}
			
			if (getUserTestDto().getNegativeMarks() == null || getUserTestDto().getNegativeMarks() > 0 ){	
				addFieldError("userTestDto.negativeMarks", "Negative marks is required." );
			}
			addTestView();
		}
	}

	/**
	 * @return the userTestDto
	 */
	public UserTestDto getUserTestDto() {
		if (userTestDto == null) {
			userTestDto = new UserTestDto();
		}
		return userTestDto;
	}

	/**
	 * @param userTestDto the userTestDto to set
	 */
	public void setUserTestDto(UserTestDto userTestDto) {
		this.userTestDto = userTestDto;
	}

	}
