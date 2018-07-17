package com.demo.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.beans.Address;
import com.demo.beans.BaseBean;
import com.demo.beans.Student;
import com.demo.beans.Subject;

@ContextConfiguration(locations = "classpath:application-config-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBaseDao {
	
	@Autowired
	private BaseDao baseDao;
	
	@Transactional
	@Test
	@Rollback(true)
	public void  testAddStudent() {
		Address addr = new Address("Nagpur", "Maharashtra");
		Set<Subject> subs = new HashSet<>();
		subs.add(new Subject("Operating System", "Grady Booch"));
		subs.add(new Subject("Data Structure", "Marvin"));
		Student student = new Student("Dheeraj", addr, subs);
		baseDao.save(student);
		Set<BaseBean> students = baseDao.fetchAll(Student.class);
		Assert.assertEquals("Comparing newly created student",student, students.iterator().next());
	}
}
