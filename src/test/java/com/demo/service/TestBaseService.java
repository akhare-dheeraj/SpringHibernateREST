package com.demo.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.beans.Address;
import com.demo.beans.BaseBean;
import com.demo.beans.Student;
import com.demo.beans.Subject;
import com.demo.dao.BaseDao;

@RunWith(MockitoJUnitRunner.class)
public class TestBaseService {
	
	@InjectMocks
	private BaseService baseService = new BaseServiceImpl();
	
	@Mock
	private BaseDao baseDao;
	
	@Test
	public void testCreateEntity() {
		Mockito.when(baseDao.save(Mockito.any(BaseBean.class))).thenReturn(new Integer(1));
		Address addr = new Address("Nagpur", "Maharashtra");
		Set<Subject> subs = new HashSet<>();
		subs.add(new Subject("Operating System", "Grady Booch"));
		subs.add(new Subject("Data Structure", "Marvin"));
		Student student = new Student("Dheeraj", addr, subs);
		Serializable id = baseService.createEntity(student);
		Assert.assertEquals("Comparing generated student id",1, id);
	}
}
