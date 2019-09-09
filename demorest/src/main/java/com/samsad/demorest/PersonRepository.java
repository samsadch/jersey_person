package com.samsad.demorest;

import java.util.ArrayList;
import java.util.List;


public class PersonRepository {
	
	List<Person> persons;
	
	public PersonRepository() {
		persons = new ArrayList<>();
		
		Person p1 = new Person();
		p1.setEmail("samsadch@gmail.com");
		p1.setName("Samsad CV");
		p1.setId(1);
		p1.setPhone("9809731990");		
		persons.add(p1);
		
		Person p2 = new Person();
		p2.setEmail("nihalabeevikp@gmail.com");
		p2.setName("Nihala Beevi KP");
		p2.setId(2);
		p2.setPhone("9388211114");		
		persons.add(p2);
		
	}
	
	public List<Person> getPersons(){
		return persons;
	}
	
	public Person getPerson(int id) {	
		
		for(Person pers: persons) {
			if(pers.getId()==id) {
				return pers;
			}
		}
		
		return new Person();
	}

	public void create(Person person) {
		persons.add(person);
		
	}

}
