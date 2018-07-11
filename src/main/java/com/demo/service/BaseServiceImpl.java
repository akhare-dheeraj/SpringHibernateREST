package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.beans.BaseBean;
import com.demo.dao.BaseDao;

public class BaseServiceImpl implements BaseService{

	@Autowired
	private BaseDao baseDao;
	
	public void createEntity(BaseBean bean) {
		baseDao.save(bean);
	}
}
