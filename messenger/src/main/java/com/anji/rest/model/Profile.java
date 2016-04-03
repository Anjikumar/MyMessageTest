package com.anji.rest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	private long id;
	private String profieName;
	private String firstName;
	private String lastName;
	private Date created;
	
	public Profile()
	{
	
	}


	public Profile(long id,String profilename,String firstname,String lastname)
	{
		this.id=id;
		this.profieName=profilename;
		this.firstName=firstname;
		this.lastName=lastname;	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProfieName() {
		return profieName;
	}


	public void setProfieName(String profieName) {
		this.profieName = profieName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}

	
}
