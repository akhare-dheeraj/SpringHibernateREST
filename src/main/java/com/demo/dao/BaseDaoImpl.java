package com.demo.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.BaseBean;

@SuppressWarnings("rawtypes")
public class BaseDaoImpl implements BaseDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public Serializable save(BaseBean bean) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Serializable id = session.save(bean);
		tx.commit();
		session.close();
		return id;
	}

	public void deleteById(int id, Class className) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BaseBean bean = fetchById(id, className);
		session.delete(bean);
		tx.commit();
		session.close();
	}

	public Set<BaseBean> fetchAll(Class className) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Set<BaseBean> beans = new HashSet<BaseBean>(session.createCriteria(className).list());
		session.close();
		return beans;
	}

	
	public BaseBean fetchById(Serializable id, Class className) {
		Session session = sessionFactory.openSession();
		BaseBean bean = (BaseBean) session.get(className, id);
		session.close();
		return bean;
	}
}
