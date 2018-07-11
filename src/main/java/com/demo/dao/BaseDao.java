package com.demo.dao;

import java.util.Set;

import com.demo.beans.BaseBean;

public interface BaseDao {

	public void save(BaseBean bean);
	public void deleteById(int id, Class className);
	public Set<BaseBean> fetchAll(Class className);
	public BaseBean fetchById(int id, Class className);
}
