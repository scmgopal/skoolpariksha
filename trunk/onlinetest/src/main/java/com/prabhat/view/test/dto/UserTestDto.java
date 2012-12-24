package com.prabhat.view.test.dto;

import java.util.List;

import javax.persistence.Column;

import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.UserClass;

public class UserTestDto {

	private Long testId;
	private String testName;
	private String actionName;
	private Long classId;
	private Integer noOfQuestion;
	private Integer questionMarks;
	private Integer negativeMarks;
	private Boolean isActive;
	private List<Test> tests;
	List<UserClass> userClasses;
	
	/**
	 * @return the testName
	 */
	public String getTestName() {
		return testName;
	}
	/**
	 * @param testName the testName to set
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}
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
	 * @return the tests
	 */
	public List<Test> getTests() {
		return tests;
	}
	/**
	 * @param tests the tests to set
	 */
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	/**
	 * @return the testId
	 */
	public Long getTestId() {
		return testId;
	}
	/**
	 * @param testId the testId to set
	 */
	public void setTestId(Long testId) {
		this.testId = testId;
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
	 * @return the noOfQuestion
	 */
	public Integer getNoOfQuestion() {
		return noOfQuestion;
	}
	/**
	 * @param noOfQuestion the noOfQuestion to set
	 */
	public void setNoOfQuestion(Integer noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}
	/**
	 * @return the questionMarks
	 */
	public Integer getQuestionMarks() {
		return questionMarks;
	}
	/**
	 * @param questionMarks the questionMarks to set
	 */
	public void setQuestionMarks(Integer questionMarks) {
		this.questionMarks = questionMarks;
	}
	/**
	 * @return the negativeMarks
	 */
	public Integer getNegativeMarks() {
		return negativeMarks;
	}
	/**
	 * @param negativeMarks the negativeMarks to set
	 */
	public void setNegativeMarks(Integer negativeMarks) {
		this.negativeMarks = negativeMarks;
	}
	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

}
