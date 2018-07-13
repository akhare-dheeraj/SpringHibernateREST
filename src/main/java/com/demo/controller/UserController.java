package com.demo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	public User createUser(User user) {
		System.out.println("Creating user:"+user);
		service.createEntity(user);
		System.out.println("Created user:"+user);
		return user;
	}
}
