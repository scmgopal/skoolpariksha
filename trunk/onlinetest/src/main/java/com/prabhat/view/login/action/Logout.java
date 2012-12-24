package com.prabhat.view.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 294631726283690565L;

	public String execute() throws Exception{
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 request.getSession().invalidate();
		 response.sendRedirect("showLogin.action");
		return null;
	}
}
