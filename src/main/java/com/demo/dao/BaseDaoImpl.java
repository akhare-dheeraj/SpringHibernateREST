package com.demo.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.beans.BaseBean;

public class BaseDaoImpl implements BaseDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public void save(BaseBean bean) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bean);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteById(int id, Class className) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BaseBean bean = fetchById(id, className);
		session.delete(bean);
		session.getTransaction().commit();
		session.close();
	}

	public Set<BaseBean> fetchAll(Class className) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Set<BaseBean> beans = new HashSet<BaseBean>(session.createCriteria(className).list());
		return beans;
	}

	public BaseBean fetchById(int id, Class className) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BaseBean bean = (BaseBean) session.get(className, id);
		session.close();
		return bean;
	}

}
