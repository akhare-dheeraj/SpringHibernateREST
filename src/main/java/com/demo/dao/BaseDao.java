package com.demo.dao;

import java.io.Serializable;
import java.util.Set;

import com.demo.beans.BaseBean;

@SuppressWarnings("rawtypes")
public interface BaseDao {

	public Serializable save(BaseBean bean);
	public void deleteById(int id,  Class className);
	public Set<BaseBean> fetchAll(Class className);
	public BaseBean fetchById(Serializable id, Class className);
}
