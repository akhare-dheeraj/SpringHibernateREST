package com.demo.service;

import java.io.Serializable;
import java.util.Set;

import com.demo.beans.BaseBean;

@SuppressWarnings("rawtypes")
public interface BaseService {
	public Serializable createEntity(BaseBean bean);

	
	public BaseBean getEntitiyById(Serializable id, Class className);
	
	public Set<BaseBean> getAllEntitties(Class className);
}
