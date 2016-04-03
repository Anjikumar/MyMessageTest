package com.anji.rest.client;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.anji.rest.model.Message;

public class RestAPIClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client cl=ClientBuilder.newClient();
		Response rs=cl.target("http://localhost:5050/messenger/webapi/messages/1").request().get();
		Message mss=rs.readEntity(Message.class);
		System.out.println(mss.getId());
		
		
	/*	
		WebTarget wt= cl.target("http://localhost:5050/messenger/webapi/messages/1");
		Builder bd= wt.request();
		Response rs1= bd.get();*/
		
		
		//recomended best practices
		
		WebTarget baseTarget=cl.target("http://localhost:5050/messenger/webapi");
		WebTarget messagesTarget=baseTarget.path("messages");
		WebTarget singlemesageTarget=messagesTarget.path("{messageid}");
		
		Message m1=singlemesageTarget.resolveTemplate("messageid", "2").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(m1.getAuthor());
		
		
		
		//post request
		Message mes=new Message(5, "from post through client", "Anji");
		
		Response res= messagesTarget.request().post(Entity.json(mes));
		Message postRespo=res.readEntity(Message.class);
		System.out.println(postRespo.getMessage());
		
	}

}
