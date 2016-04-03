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
import javax.ws.rs.core.MediaType;

import com.anji.rest.model.Message;
import com.anji.rest.model.Profile;
import com.anji.rest.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResources {

	ProfileService p=new ProfileService();
	
	@GET
	public List<Profile> getProfiles()
	{
		return p.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile prof)
	{
		return p.addProfile(prof);
	}
	
	@GET
	@Path("/{profilename}")
	public Profile getProfile(@PathParam("profilename")String profileName)
	{
		return p.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profilename}")
	public Profile updateProfile(@PathParam("profilename")String profileName,Profile pro)
	{
		pro.setProfieName(profileName);
		return p.updateProfile(pro);
	}
	
	@DELETE
	@Path("/{profilename}")
	public Profile deleteProfile(@PathParam("profilename")String prfielname)
	{
		return p.removeProfile(prfielname);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
