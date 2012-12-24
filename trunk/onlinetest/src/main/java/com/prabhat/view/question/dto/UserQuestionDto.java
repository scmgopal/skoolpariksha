package com.prabhat.view.question.dto;

import java.util.List;

import javax.persistence.Column;

import com.prabhat.hibernate.entity.Question;

public class UserQuestionDto {
	private String actionName;
	private Long questionId;
	private Long testId;
	private String questionName;
	
	private String optA;
	
	private String optB;
	
	private String optC;
	
	private String optD;
	
	private String optE;
	
	private String optAns;
	
	
	private List<Question> questionList;

	private String[] studentChoice;
	
	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}


	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
	 * @return the questionName
	 */
	public String getQuestionName() {
		return questionName;
	}


	/**
	 * @param questionName the questionName to set
	 */
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}


	/**
	 * @return the questionList
	 */
	public List<Question> getQuestionList() {
		return questionList;
	}


	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
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
	 * @return the optA
	 */
	public String getOptA() {
		return optA;
	}


	/**
	 * @param optA the optA to set
	 */
	public void setOptA(String optA) {
		this.optA = optA;
	}


	/**
	 * @return the optB
	 */
	public String getOptB() {
		return optB;
	}


	/**
	 * @param optB the optB to set
	 */
	public void setOptB(String optB) {
		this.optB = optB;
	}


	/**
	 * @return the optC
	 */
	public String getOptC() {
		return optC;
	}


	/**
	 * @param optC the optC to set
	 */
	public void setOptC(String optC) {
		this.optC = optC;
	}


	/**
	 * @return the optD
	 */
	public String getOptD() {
		return optD;
	}


	/**
	 * @param optD the optD to set
	 */
	public void setOptD(String optD) {
		this.optD = optD;
	}


	/**
	 * @return the optE
	 */
	public String getOptE() {
		return optE;
	}


	/**
	 * @param optE the optE to set
	 */
	public void setOptE(String optE) {
		this.optE = optE;
	}


	/**
	 * @return the optAns
	 */
	public String getOptAns() {
		return optAns;
	}


	/**
	 * @param optAns the optAns to set
	 */
	public void setOptAns(String optAns) {
		this.optAns = optAns;
	}


	/**
	 * @return the studentChoice
	 */
	public String[] getStudentChoice() {
		return studentChoice;
	}


	/**
	 * @param studentChoice the studentChoice to set
	 */
	public void setStudentChoice(String[] studentChoice) {
		this.studentChoice = studentChoice;
	}
}
