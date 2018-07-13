package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.User;

public class UserDao extends BaseDaoImpl {
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createCriteria(User.class).add(Restrictions.eq("userName",userName)).uniqueResult();
		return user;
	}
}
