package com.demo.auth.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.auth.authenticator.Authenticator;
import com.demo.constants.Constant;
import com.google.gson.JsonObject;

@Provider
public class CustomRequestFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	
	@Autowired
	private Authenticator authenticator;
	
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		String credsStr = getDecodedAuthString(context);
		System.out.println("decoded authorization header:"+credsStr);
		boolean authStatus = authenticate(credsStr);
		if(!authStatus){
			JsonObject authFail = new JsonObject();
			authFail.addProperty("status", "fail");
			authFail.addProperty("msg", "Authentication failed");
			context.abortWith(Response.ok(authFail.toString()).build());
			return;
		}
		Method method = resourceInfo.getResourceMethod();
		
		if(method.isAnnotationPresent(DenyAll.class)) {
			JsonObject deny = new JsonObject();
			deny.addProperty("status", "unauthorized");
			context.abortWith(Response.status(Status.FORBIDDEN).entity(deny.toString()).build());
			return;
		}
	}
	
	private static String getDecodedAuthString(ContainerRequestContext context) {
		String authString = null;
		List<String> encodedCreds = context.getHeaders().get(Constant.AUTH_HEADER);
		System.out.println("Encoded creds:"+encodedCreds);
		if(encodedCreds!=null && encodedCreds.size()>0) {
			String encodedString = encodedCreds.get(0);
			String[] hdr = encodedString.split("\\s+");
			if(hdr.length==2) {
				if(hdr[0].equals("Basic")) {
					authString = decode(hdr[1]);
				}
			}
		}
		return authString;
	}
	
	private static String decode(String encodedStr) {
		try {
			return new String(Base64.getDecoder().decode(encodedStr),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private boolean authenticate(String credsStr) {
		String[] token = credsStr.split(":");
		if(token.length>1) {
			return authenticator.authenticate(token[0], token[1]);
		}
		return false;
	}
}
