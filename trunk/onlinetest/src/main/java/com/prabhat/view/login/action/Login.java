package com.prabhat.view.login.action;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.prabhat.hibernate.entity.Role;
import com.prabhat.hibernate.entity.User;
import com.prabhat.service.login.LoginService;


/**
 * <p> Validate a user login. </p>
 */
public  class Login  extends ActionSupport {

	private static final long serialVersionUID = 6726771320549743797L;


	public String execute() throws Exception {
    	LoginService loginService = new LoginService();
    	 HttpServletRequest requst = ServletActionContext.getRequest();
    	 try {
			if (loginService.userLoginAuthenticate(getLoginName(), getPassword())){
				 User user = loginService.getLoginUser(getLoginName());
				 if (user == null) {
					 addActionError("You have not permission to access this page. Please Contact to admin !");
						return ERROR;
				 }
				 boolean hasAdminRole = loginService.hasAdmin(user.getRole());
				 if (hasAdminRole) {
					 requst.getSession().setAttribute("hasAdminRole", "true");
				 }
				 requst.getSession().setAttribute("loginUser", user);
				 HttpServletResponse response = ServletActionContext.getResponse();
				 if (user.getRole().equals(Role.TEACHER)) {
					 response.sendRedirect("doUserTest.action");
				 } else if (user.getRole().equals(Role.USER)){
					 response.sendRedirect("doSudentAction.action");
				 }
				
				return null;
			} else {
				addActionError("Invalid user name or password! Please try again!");
				return ERROR;
			}
		
		} catch (IOException e) {
			addActionError("Invalid user name or password! Please try again!");
			return ERROR;
		}
        
	}


    // ---- Username property ----

    /**
     * <p>Field to store User username.</p>
     * <p/>
     */
    private String loginName = null;


    /**
	 * @return the loginName
	 */
	public String getLoginName() {
		if (loginName != null) {
			this.loginName = this.loginName.toLowerCase();
		}
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

    /**
     * <p>Field to store User password.</p>
     * <p/>
     */
    private String password = null;


    /**
     * <p>Provide User password.</p>
     *
     * @return Returns the User password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Store new User password</p>
     *
     * @param value The password to set.
     */
    public void setPassword(String value) {
        password = value;
    }

}
