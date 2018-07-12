package com.demo.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.beans.BaseBean;
import com.demo.dao.BaseDao;

public class BaseServiceImpl implements BaseService{

	@Autowired
	private BaseDao baseDao;
	
	public Serializable createEntity(BaseBean bean) {
		return baseDao.save(bean);
	}

	@Override
	public BaseBean getEntitiyById(Serializable id, Class className) {
		BaseBean bean = baseDao.fetchById(id, className);
		return bean;
	}
	
}
