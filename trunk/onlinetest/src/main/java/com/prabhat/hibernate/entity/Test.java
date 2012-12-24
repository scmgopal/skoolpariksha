package com.prabhat.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8260883121206124263L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="class_id")
	private UserClass testClass;
	
	@Column(name = "no_of_question")
	private Integer noOfQuestion;
	
	@Column(name = "marks_each_questin")
	private Integer questionMarks;
	
	@Column(name = "negative_marks_each_questin")
	private Integer negativeMarks;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="school_id")
	private School school;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	/**
	 * @return the testClass
	 */
	public UserClass getTestClass() {
		return testClass;
	}
	/**
	 * @param testClass the testClass to set
	 */
	public void setTestClass(UserClass testClass) {
		this.testClass = testClass;
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
	  

}
