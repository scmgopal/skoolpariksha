package com.prabhat.view.user.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prabhat.hibernate.entity.UserClass;
import com.prabhat.service.user.UserService;
import com.prabhat.view.user.dto.UserDto;

public class UserAction extends ActionSupport {
	
	private UserDto userDto;
	
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("actionName");
		if (action == null) {
			action = getUserDto().getActionName();
		}
		if (action != null && action.equals("addUserView")) {
			return addUserView();
		}
		if (action != null && action.equals("addUser")) {
			return addUser();
		} else {
			return showUserPage();
		}
	}
	
	private String showUserPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		UserService userService = new UserService();
		getUserDto().setUserList(userService.findUsersOnSchool(request));
		return "userpage";
	}
	
	private String addUserView() {
		UserService userService = new UserService();
		List<UserClass> userClasses = userService.getAllUserClass();
		getUserDto().setUserClasses(userClasses);
		return "adduserpage";
	}
	
	private String addUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		UserService userService = new UserService();
		userService.addUser(getUserDto(), request);
		return showUserPage();
	}

	
	public void validate() {
		if (getUserDto().getActionName() != null && getUserDto().getActionName().equals("addUser")) {
			if ( getUserDto().getFirstName().trim().length() == 0 ){	
				addFieldError("userDto.firstName", "First name is required." );
			}
			
			if ( getUserDto().getLastName().trim().length() == 0 ){	
				addFieldError("userDto.lastName", "Last name is required." );
			}
			
			if ( getUserDto().getClassId() == -1 ){	
				addFieldError("userDto.classId", "Class is required." );
			}
			addUserView();
		}
	}
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
}
