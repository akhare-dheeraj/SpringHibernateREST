package com.demo.service;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.BaseBean;
import com.demo.dao.BaseDao;

@SuppressWarnings("rawtypes")
public class BaseServiceImpl implements BaseService{

	@Autowired
	private BaseDao baseDao;
	
	public Serializable createEntity(BaseBean bean) {
		return baseDao.save(bean);
	}

	@Override
	public BaseBean getEntitiyById(Serializable id,  Class className) {
		BaseBean bean = baseDao.fetchById(id, className);
		return bean;
	}

	@Override
	public Set<BaseBean> getAllEntitties(Class className) {
		return baseDao.fetchAll(className);
	}

	@Override
	public BaseBean updateBean(BaseBean bean) {
		return baseDao.update(bean);
	}

	@Override
	public boolean deleteBean(Serializable id, Class className) {
		return baseDao.delete(id, className);
	}
	
	
}
