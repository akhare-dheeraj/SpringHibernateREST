package com.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.demo.beans.Address;
import com.demo.beans.Student;
import com.demo.beans.Subject;

public class TestStudentController extends JerseyTest {

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(StudentController.class).property("contextConfigLocation",
				"classpath:application-config-test.xml");
	}

	@Test
	public void testCreateStudent() {
		Address addr = new Address("Nagpur", "Maharashtra");
		Set<Subject> subs = new HashSet<>();
		subs.add(new Subject("Operating System", "Grady Booch"));
		subs.add(new Subject("Data Structure", "Marvin"));
		Student student = new Student("Dheeraj", addr, subs);
		Response resp = target("/student/create").request().post(Entity.entity(student, MediaType.APPLICATION_JSON));
		assertNotNull(resp);
		assertEquals("Status should be 200", 200, resp.getStatus());
	}
}
