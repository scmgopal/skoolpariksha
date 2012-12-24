package com.prabhat.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.prabhat.hibernate.entity.Question;
import com.prabhat.hibernate.entity.School;
import com.prabhat.hibernate.entity.Test;
import com.prabhat.hibernate.entity.UserTestAns;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao{

	@Override
	public void addTest(Test test) {
		getHibernateTemplate().saveOrUpdate(test);
	}

	public Test getTest(Long testId) {
		return (Test)getHibernateTemplate().get(Test.class, testId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getTestsOnSchool(School school) {
		Criteria criteria = getSession().createCriteria(Test.class);
		criteria.add(Restrictions.eq("school", school));
		return  criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(Long testId) {
		Criteria criteria = getSession().createCriteria(Question.class);
		criteria.add(Restrictions.eq("test.id", testId));
		return  criteria.list();
	}

	@Override
	public Question getQuestion(Long questionId) {
		Criteria criteria = getSession().createCriteria(Question.class);
		criteria.add(Restrictions.eq("id", questionId));
		return  (Question)criteria.list().get(0);
	}

	@Override
	public void saveQuestion(Question question) {
		getHibernateTemplate().save(question);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getUnAttempedTest(Long userId) {
		StringBuffer query = new StringBuffer();
		query.append("select * from test where is_active=true and id not in (select test_id from user_test where user_id=").append(userId).append(") and no_of_question < (select count(*) from question where test_id=test.id)");
		Query sqlQuery = getSession().createSQLQuery(query.toString()).addEntity(Test.class);
		return sqlQuery.list();
	}
	
	public void saveAllUserTestAns(List<UserTestAns> userTestAnsList) {
		getHibernateTemplate().saveOrUpdateAll(userTestAnsList);
	}
	
	public void updateUserTest(Long userId, Long testId) {
		StringBuffer query = new StringBuffer();
		query.append("insert into user_test (user_id, test_id) values(").append(userId).append(", ").append(testId).append(")");
		try {
			getSession().connection().createStatement().executeUpdate(query.toString());
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
