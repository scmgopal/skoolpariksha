package com.prabhat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prabhat.hibernate.entity.Role;
import com.prabhat.hibernate.entity.User;

public class UrlFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest genericRequest, ServletResponse genericResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) genericRequest;
		HttpServletResponse response = (HttpServletResponse) genericResponse;
		String requestedURI = request.getRequestURI() ;
		if (requestedURI.indexOf(".action") > 1) {
			if (requestedURI.indexOf("showLogin") >0 ||requestedURI.indexOf("doLogin.action")>0) {
				chain.doFilter(request, response);
				return;
			} else {
				User user = (User)request.getSession().getAttribute("loginUser");
				if (user==null) {
					response.sendRedirect("showLogin.action");
					return;
				} else {
					if (user.getRole().equals(Role.USER)){
						if (!(requestedURI.indexOf("doLogout.action")>0) && !(requestedURI.indexOf("doSudentAction")>0)) {
							response.sendRedirect("doLogout.action");
							return;
						}
					}
					chain.doFilter(request, response);
					return;
				}
			}
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
