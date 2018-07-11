package com.demo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

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
}
