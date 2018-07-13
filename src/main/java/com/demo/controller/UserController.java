package com.demo.controller;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.beans.User;
import com.demo.service.BaseService;

@Path("/user")
public class UserController {

	@Autowired
	BaseService service;
	
	@GET
	@Path("/test")
	public String testUser() {
		return "Hello User";
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println("Creating user:"+user);
		service.createEntity(user);
		System.out.println("Created user:"+user);
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") Integer id) {
		return Response.ok(service.getEntitiyById(id, User.class)).build();
	}
}
