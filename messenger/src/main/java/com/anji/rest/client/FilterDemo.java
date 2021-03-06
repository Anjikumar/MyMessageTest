package com.anji.rest.client;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class FilterDemo implements ContainerRequestFilter, ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		System.out.println(responseContext.getHeaders());
		responseContext.getHeaders().add("MY Header", "Anji Header");
		System.out.println("HIII");
		
		
		System.out.println("HIII secon time added for test");
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		System.out.println(requestContext.getHeaders());	
	}

}
