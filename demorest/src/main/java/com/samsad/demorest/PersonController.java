package com.samsad.demorest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persons")
public class PersonController {
	
	PersonRepository repo = new PersonRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Person> getPersons() {
				
		return repo.getPersons();
	}
	
	@GET
	@Path("person/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("id") int id) {		
		return repo.getPerson(id);		
	}
	
	@POST
	@Path("person")
	public Person createPerson(Person person) {		
		
		repo.create(person);		
		
		return person;
	}
	

}
