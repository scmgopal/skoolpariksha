package com.prabhat.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_test_ans")
public class UserTestAns implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -988854246323523007L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "test_id")
	private Long testId;
	
	@Column(name = "question_id")
	private Long questionId;
	
	@Column(name = "user_ans")
	private String answer;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
