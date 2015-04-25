package it.piergiuseppe82.hangapp.services.bean;

import it.piergiuseppe82.hangapp.services.repositories.model.Person;

public interface AccountServices {
	
	public int registerPerson(Person person);
	
	public Person checkPerson(String username, String password);
}
