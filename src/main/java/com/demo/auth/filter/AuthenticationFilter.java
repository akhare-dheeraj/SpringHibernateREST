package com.demo.auth.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.DenyAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.google.gson.JsonObject;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		Method method = resourceInfo.getResourceMethod();
		if(method.isAnnotationPresent(DenyAll.class)) {
			JsonObject deny = new JsonObject();
			deny.addProperty("status", "unauthorized");
			context.abortWith(Response.status(Status.FORBIDDEN).entity(deny.toString()).build());
			return;
		}
	}

}
