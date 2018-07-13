package com.demo.auth.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.demo.auth.filter.CustomRequestFilter;

public class CustomResourceConfig extends ResourceConfig {
	public CustomResourceConfig() {
		packages("com.demo.filter");
		packages("com.demo.controller");
		register(CustomRequestFilter.class);
	}
}
