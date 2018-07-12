package com.demo.controller;

import java.io.Serializable;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.BaseBean;
import com.demo.beans.Student;
import com.demo.service.BaseService;
import com.google.gson.JsonObject;

@Path("/student")
public class StudentController {

	@Autowired
	private BaseService service;

	@Path("/test")
	@GET
	public String test() {
		return "Running!";
	}

	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response createStudent(Student student) {
		try {
			System.out.println(student);
			Serializable id = service.createEntity(student);
			student = (Student) service.getEntitiyById(id, Student.class);
			return Response.ok(student).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentById(@PathParam(value = "id") Integer id) {
		Student stu = (Student) service.getEntitiyById(id, Student.class);
		if (stu == null)
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(stu).build();
	}

	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudents() {
		Set<BaseBean> students = service.getAllEntitties(Student.class);
		if (students == null)
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(students).build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(Student student) {
		try {
		service.updateBean(student);
		} catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.ok(student).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") Integer id) {
		boolean status = service.deleteBean(id, Student.class);
		JsonObject res = new JsonObject();
		res.addProperty("status", status);
		return Response.ok(res.toString()).build();
	}
	
}
