package com.anji.rest.database;
import java.util.HashMap;
import java.util.Map;

import com.anji.rest.model.Message;
import com.anji.rest.model.Profile;
public class DabaBaseClass {

	public static Map<Long,Message> messages= new HashMap<>();
	public static Map<String,Profile> profiels=new HashMap<>();
	
	public static Map<Long,Message> getMessages()
	{
		return messages;
	}
	public static Map<String,Profile> getProfiles()
	{
		return profiels;
	}
}
