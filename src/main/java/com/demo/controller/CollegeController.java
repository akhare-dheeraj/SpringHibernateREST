package com.demo.controller;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.Student;
import com.demo.service.BaseService;

@Path("/college")
public class CollegeController {

	@Autowired
	private BaseService service;
	
	@Path("/test")
	@GET
	public String test() {
		return "Running!";
	}
	
	@Path("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Student createStudent(Student student) {
		System.out.println(student);
		Serializable id = service.createEntity(student);
		student = (Student) service.getEntitiyById(id, Student.class);
		return student;
	}
}
