package com.prabhat.service.login;

import com.prabhat.common.ContextProvider;
import com.prabhat.hibernate.dao.UserDao;
import com.prabhat.hibernate.entity.Role;
import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.User;

public class LoginService {
	
	public boolean userLoginAuthenticate(String loginId, String password) {
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		return userDao.isValidUsser(loginId, password);
	}
	
	public User getLoginUser(String userId) {
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		return userDao.getUserOnUserId(userId);
	}
	
	public boolean hasAdmin(Role role) {
		return role == Role.ADMIN;
	}
	
	public static void main(String[] s) {
		/*LoginService loginService = new LoginService();
		try {
			boolean test = loginService.userLoginAuthenticate("prabhat553", "pbht@1232");
			System.out.println("test   =" +test);
		} catch (LdapException e) {
			e.printStackTrace();
		}*/
		User user = new User();
		user.setActive(Boolean.TRUE);
		//user.setClassStanderd(9);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setLoginId("test");
		user.setPassword("test");
		user.setRole(Role.ADMIN);
		School school = new School();
		school.setId(1L);
		user.setSchool(school);
		UserDao userDao = (UserDao)ContextProvider.gtApplicationContext().getBean("userDao");
		userDao.addUser(user);
		/*List<User> userList = userDao.findAllUser();
		for (User user : userList) {
			System.out.println(user.getFirstName());
		}*/
	}
}
