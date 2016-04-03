package com.anji.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InvocationDemo i=new InvocationDemo();
		Invocation in= i.processReqByYear(2016);
		Response res=in.invoke();
		System.out.println(res.getStatus());
		

	}
	
	public Invocation processReqByYear(int year)
	{
		Client cl=ClientBuilder.newClient();
		
		return cl.target("http://localhost:5050/messenger/webapi/").path("messages").queryParam("year",2016).request(MediaType.APPLICATION_JSON)
		.buildGet();
		
		
		
	}

}
