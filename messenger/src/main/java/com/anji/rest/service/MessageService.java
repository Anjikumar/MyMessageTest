package com.anji.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anji.rest.database.DabaBaseClass;
import com.anji.rest.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages=DabaBaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"Hllow world","Anji"));
		messages.put(2L, new Message(2,"Hellow My Java","Arun"));
		
	}
	
	
	
	public List<Message> getMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getMessageByYear(int year)
	{
		List<Message> messbyYear=new ArrayList<Message>();
		ArrayList<Message> ll=new ArrayList<Message>(messages.values());
		for (Message m: ll) {
			if(m.getCreated().toString().contains(Integer.toString(year)))
			{
				messbyYear.add(m);
			}
		}
		return messbyYear;
	}
	
	public List<Message> getAllMessagesInRange(int start, int size)
	{
		ArrayList<Message> ll=new ArrayList<Message>( messages.values());
		if(start+size<ll.size())
		ll.subList(start, start+size);
		return ll;
		
	}
	
	
	public Message grtMessage(long id)
	{
		return messages.get(id);
	}
	public Message addMesage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;	
	}
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;			
	}
	public Message removeMessa(long id)
	{
		return messages.remove(id);
	}
	
	

}
