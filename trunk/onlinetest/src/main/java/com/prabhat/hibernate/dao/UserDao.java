package com.prabhat.hibernate.dao;

import java.util.List;

import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;

public interface UserDao {

	public boolean isValidUsser(String loginId, String password);
	public List<User> findAllUser();
	public User getUserOnUserId(String loginName);
	List<User> findUsersOnSchool(School school);
	void addUser(User user);
	List<UserClass> getAllUserClass();
}
