package it.piergiuseppe82.neo4jspring.services;

import it.piergiuseppe82.neo4jspring.entity.Person;

public interface AccountServices {
	
	public int registerPerson(Person person);
	
	public Person checkPerson(String username, String password);
}
