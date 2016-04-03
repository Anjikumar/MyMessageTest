package com.anji.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anji.rest.database.DabaBaseClass;
import com.anji.rest.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiels=DabaBaseClass.getProfiles();
	
	
	public ProfileService()
	{
		profiels.put("Anji", new Profile(1L,"Anji","Anji","Indugla"));
	}
	
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiels.values());
	}
	public Profile getProfile(String name)
	{
			return profiels.get(name);
	}
	public Profile addProfile(Profile profiel)
	{
		profiel.setId(profiels.size()+1);
		profiels.put(profiel.getProfieName(), profiel);
		return profiel;
	}
	public Profile updateProfile(Profile pro)
	{
		if(pro.getProfieName().isEmpty())
		{
			return null;
		}
		pro.setId(profiels.size()+1);
		profiels.put(pro.getProfieName(), pro);
			return pro;
	}
	public Profile removeProfile(String profileName)
	{
		return profiels.remove(profileName);
	}
	
	
	
	
}
