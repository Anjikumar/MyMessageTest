package com.anji.rest.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class CommentResource {
	
	@GET
	public String test()
	{
		return "test string";
	}
	
	@GET
	@Path("/{commentid}")
	public String test2()
	{
		return "commment id";
	}
}
