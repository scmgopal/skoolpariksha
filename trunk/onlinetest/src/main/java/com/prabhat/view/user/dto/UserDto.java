package com.prabhat.view.user.dto;

import java.util.List;

import com.prabhat.hibernate.entity.Question;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;

public class UserDto {

	private String actionName;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long classId;
	
	private List<UserClass> userClasses;
	private List<User> userList;
	private List<Test> pendingTestList;
	private List<Test> submittedTestList;
	
	
	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}
	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	/**
	 * @return the userClasses
	 */
	public List<UserClass> getUserClasses() {
		return userClasses;
	}
	/**
	 * @param userClasses the userClasses to set
	 */
	public void setUserClasses(List<UserClass> userClasses) {
		this.userClasses = userClasses;
	}
	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	/**
	 * @return the pendingTestList
	 */
	public List<Test> getPendingTestList() {
		return pendingTestList;
	}
	/**
	 * @param pendingTestList the pendingTestList to set
	 */
	public void setPendingTestList(List<Test> pendingTestList) {
		this.pendingTestList = pendingTestList;
	}
	/**
	 * @return the submittedTestList
	 */
	public List<Test> getSubmittedTestList() {
		return submittedTestList;
	}
	/**
	 * @param submittedTestList the submittedTestList to set
	 */
	public void setSubmittedTestList(List<Test> submittedTestList) {
		this.submittedTestList = submittedTestList;
	}
}
