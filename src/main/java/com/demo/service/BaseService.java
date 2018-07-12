package com.demo.service;

import java.io.Serializable;

import com.demo.beans.BaseBean;

public interface BaseService {
	public Serializable createEntity(BaseBean bean);

	public BaseBean getEntitiyById(Serializable id, Class className);
}
