package com.anji.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.model.ParamQualifier;

import com.anji.rest.model.Message;
import com.anji.rest.service.MessageService;


@Path("messages")
public class MessageResources {
	
	MessageService m=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year")int year,@QueryParam("start")int start,@QueryParam("size")int size)
	{
		if(year>0)
		{
			return m.getMessageByYear(year);
		}
		if(start>=0 && size>=0)
		{
			return m.getAllMessagesInRange(start, size);
		}
		return m.getMessages();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long id)
	{
		return m.grtMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMesssage(Message message, @Context UriInfo uri)
	{
		Message temp=m.addMesage(message);
		String messadid=Long.toString(temp.getId());
		String myadd= uri.getAbsolutePathBuilder().path(messadid).build().toString();
		
		
		return Response.status(Status.CREATED).entity(temp)
				.header("URI",myadd)
				.build();
	}
	
	@PUT
	@Path("/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updaeMessage(@PathParam("messageid")long id, Message message)
	{
		message.setId(id);
		return m.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageid")long id)
	{
		 m.removeMessa(id);
	}
	
	@Path("/{messageid}/comments")
	public CommentResource getCommentRes()
	{
		return new CommentResource();
	}
	
}
