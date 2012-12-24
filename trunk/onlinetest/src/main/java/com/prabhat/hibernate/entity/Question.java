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
@Table(name = "question")
public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1747448637248396797L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(name = "option_a")
	private String optA;
	
	@Column(name = "option_b")
	private String optB;
	
	@Column(name = "option_c")
	private String optC;
	
	@Column(name = "option_d")
	private String optD;
	
	@Column(name = "option_e")
	private String optE;
	
	@Column(name = "ans_opt")
	private String optAns;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "test_id")
	private Test test;


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
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}


	/**
	 * @param test the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}
	  
}
