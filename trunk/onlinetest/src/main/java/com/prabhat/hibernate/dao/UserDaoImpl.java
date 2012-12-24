package com.prabhat.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.prabhat.hibernate.entity.Role;
import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.User;
import com.prabhat.hibernate.entity.UserClass;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	@SuppressWarnings("unchecked")
	public boolean isValidUsser(String loginId, String password){
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("loginId", loginId));
		criteria.add(Restrictions.eq("password", password));
		List<User> userList = criteria.list();
		if (userList != null && userList.size()>0) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		return getHibernateTemplate().getSessionFactory().openSession().createCriteria(User.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findUsersOnSchool(School school) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("school", school));
		criteria.add(Restrictions.eq("role", Role.USER));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public User getUserOnUserId(String loginName){
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("loginId", loginName));
		List<User> userList = criteria.list();
		User user = null;
		if (userList != null && userList.size()>0) {
			user = userList.get(0);
		}
		return user;//(User)getHibernateTemplate().load(User.class, userId);
	}
	
	
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserClass> getAllUserClass() {
		return getHibernateTemplate().loadAll(UserClass.class);
	}
	
	
	
}
